package com.hxzy.news.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hxzy.news.dao.UserDao;
import com.hxzy.news.entity.User;
import com.hxzy.news.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return userDao.getUser(user);
	}
	/**
	 * @author gz
	 * @time 2019年9月8日
	 * @param currentPage 当前是第几页   pageSize 每页显示多少条
	 * */
	@Override
	public Page<User> getUsers(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = new PageRequest(currentPage, pageSize);
		return userDao.findAll(pageable);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getOne(id);
	}
	@Override
	public void delUserById(int id) {
		// TODO Auto-generated method stub
		userDao.deleteById(id);
	}
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}

	@Override
	public void updateById(User user) {
		// TODO Auto-generated method stub
		userDao.updateById(user);
	}

}
