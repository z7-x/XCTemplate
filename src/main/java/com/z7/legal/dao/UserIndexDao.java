package com.z7.legal.dao;

import com.z7.legal.bean.User;
import com.z7.legal.common.RequestPram;
import com.z7.legal.common.Result;
import org.apache.lucene.queryparser.classic.ParseException;

import java.io.IOException;
import java.util.List;

/**
 * @Classname UserDao
 * @Description TODO 用户索引库接口
 * @Date 2021/4/26 11:32 上午
 * @Author z7-x
 */
public interface UserIndexDao {
    /**
     * 创建索引库
     *
     * @param users
     * @throws IOException
     */
    void createUserIndex(List<User> users) throws IOException;

    /**
     * 查询索引
     *
     * @param pageQuery
     * @return
     * @throws IOException
     * @throws ParseException
     */
    Result searchUser(RequestPram<User> pageQuery) throws IOException, ParseException;

    /**
     * 添加一个新索引
     *
     * @param user
     * @throws IOException
     */
    void addUserIndex(User user) throws IOException;

    /**
     * 通过id删除用户索引
     *
     * @param id
     * @throws IOException
     */
    void deleteUserIndexById(String id) throws IOException;

    /**
     * 通过单个搜索域 查询索引
     *
     * @param pram
     * @return
     */
    List<User> searchUser(String pram) throws IOException, ParseException;
}
