package com.hxzy.news.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hxzy.news.entity.Contents;
import com.hxzy.news.service.ContentService;

@Controller
public class NewsController {
    @Resource(name = "contentServiceImpl")
    private ContentService contentService;

    @RequestMapping("/getnews")
    public String Content(@RequestParam(required = false,name="pn") Integer pn,HttpSession session) {
        if(pn == null) {
            pn = 1;
        }

        Page<Contents> pg = contentService.getContent(pn-1, 5);

        System.out.println("列表");
        session.setAttribute("newpg", pg);
        session.setAttribute("pn", pn);
        session.setAttribute("totalpages", pg.getTotalPages());

        return "/news";
    }

    @GetMapping("/addn")
    public String re() {
        return "/addinfo";
    }

    @RequestMapping("/addnews")
    public String add(@ModelAttribute Contents content) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        content.setDatetime(sdf.format(date));
        contentService.add(content);
        return "forward:/getnews";

    }

    @GetMapping("/getnid")
    public String userinfo(@RequestParam("id") int id,HttpSession session) {
        Contents content = contentService.getContentById(id);
        session.setAttribute("new", content);
        return "/news2";
    }

    @GetMapping("/delnid")
    public String del(@RequestParam("id") int id) {
        contentService.delContentById(id);
        return "forward:/getnews";
    }
}
