package com.hxzy.news.service;


import org.springframework.data.domain.Page;

import com.hxzy.news.entity.Contents;

public interface ContentService {

    public Page<Contents> getContent(int currentPage, int pageSize);

    public void add(Contents content);

    public Contents getContentById(int id);

    public void delContentById(int id);


}
