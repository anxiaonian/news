package com.hxzy.news.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hxzy.news.dao.ContentDao;
import com.hxzy.news.entity.Contents;
import com.hxzy.news.service.ContentService;

@Service("contentServiceImpl")
public class ContentServiceImpl implements ContentService{
    @Autowired
    private ContentDao contentDao;

    @Override
    public Page<Contents> getContent(int currentPage, int pageSize)
    {
        Pageable pageable = new PageRequest(currentPage, pageSize);
        return contentDao.findAll(pageable);

    }

    @Override
    public void add(Contents Content) {
        // TODO Auto-generated method stub
        contentDao.save(Content);
    }

    @Override
    public Contents getContentById(int id)
    {
        return contentDao.getOne(id);

    }

    @Override
    public void delContentById(int id) {
        // TODO Auto-generated method stub
        contentDao.deleteById(id);
    }


}
