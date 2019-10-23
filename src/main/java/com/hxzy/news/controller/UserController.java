package com.hxzy.news.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hxzy.news.entity.User;
import com.hxzy.news.service.UserService;

@Controller
public class UserController {
	@Resource(name = "userServiceImpl")
	private UserService userService;

	@PostMapping("/login")
	public String login(@ModelAttribute User user,HttpSession session) {
		User u = userService.getUser(user);
		if(u!=null) {
			session.setAttribute("logininfo", u);
			return "/main";
		}else {
			return "/index";
		}
	}
	
	@RequestMapping("/getusers")
	public String users(@RequestParam(required = false,name="pn") Integer pn,HttpSession session) {
		if(pn == null) {
			pn = 1;
		}
		Page<User> pg = userService.getUsers(pn-1, 5);
		
		System.out.println("列表");
		session.setAttribute("userpg", pg);
		session.setAttribute("pn", pn);
		session.setAttribute("totalpages", pg.getTotalPages());

		return "/users";
	}
	
	@GetMapping("/getinfo")
	public String info() {
		System.out.println("个人");
		return "/info";
	}

	@GetMapping("/updateById")
	public String updateid(@ModelAttribute User user,HttpSession session) {
		userService.updateById(user);
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		session.setAttribute("info", user);
		return "forward:/getusers";
	}

	@GetMapping("/updateView")
	public String updateView() {

		return "updateView";
	}
	
	@GetMapping("/getid")
	public String userinfo(@RequestParam("id") int id,HttpSession session) {
		User user = userService.getUserById(id);
		session.setAttribute("info", user);
		return "/info2";
	}
	
	@GetMapping("/delid")
	public String del(@RequestParam("id") int id) {
		userService.delUserById(id);
		return "forward:/getusers";
	}


	@GetMapping("/loginout")
	public String del(HttpSession session) {
		session.setMaxInactiveInterval(0);
		return "index";
	}
	
	@GetMapping("/reg")
	public String re() {
		return "/regist";
	}
	
	@RequestMapping("/add")
	public String add(@ModelAttribute User user) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		user.setDatetime(sdf.format(date));
		userService.add(user);
		return "forward:/getusers";
	
	}
}
