package com.z7.legal.service.impl;


import com.z7.legal.bean.User;
import com.z7.legal.common.RequestPram;
import com.z7.legal.common.Result;
import com.z7.legal.dao.UserDao;
import com.z7.legal.dao.UserIndexDao;
import com.z7.legal.service.UserIndexService;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @Classname UserIndexServiceImpl
 * @Description TODO
 * @Date 2021/4/26 11:34 上午
 * @Author z7-x
 */
@Service
public class UserIndexServiceImpl implements UserIndexService {

    @Autowired
    private UserIndexDao userIndexDao;

    @Autowired
    private UserDao userDao;

    @Override
    public void synUserCreatIndex() throws IOException {
        // 先获取所有的用户信息
        List<User> userList = userDao.findAll();
        // 再将获取的用户信息创建索引库
        userIndexDao.createUserIndex(userList);
    }

    @Override
    public Result searchUser(RequestPram<User> pageQuery) throws IOException, ParseException {
        return userIndexDao.searchUser(pageQuery);
    }

    @Override
    public List<User> searchUser(String pram) throws IOException, ParseException {
        return userIndexDao.searchUser(pram);
    }
}
