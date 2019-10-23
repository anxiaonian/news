package com.hxzy.news.service;

import org.springframework.data.domain.Page;

import com.hxzy.news.entity.User;

public interface UserService {
	public User getUser(User user);
	
	public Page<User> getUsers(int currentPage,int pageSize);

	public User getUserById(int id);

	//public User updateById(int id);
	
	public void delUserById(int id);

	public void updateById(User user);
	
	public void add(User user);
}
