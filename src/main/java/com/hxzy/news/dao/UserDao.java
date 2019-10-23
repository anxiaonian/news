package com.hxzy.news.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hxzy.news.entity.User;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UserDao extends JpaRepository<User, Integer>{
	@Query("from User u where u.username = :#{#user.username} and u.password = :#{#user.password}")
	public User getUser(User user);

	@Modifying
	@Transactional
	@Query("update User u set u.username = :#{#user.username} , u.password = :#{#user.password} where u.username = :#{#user.username}")
	public void updateById(@Param("user")User user);
}
