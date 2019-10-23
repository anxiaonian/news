package com.hxzy.news.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hxzy.news.entity.Contents;

public interface ContentDao extends JpaRepository<Contents, Integer>{


}
