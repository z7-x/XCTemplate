package com.z7.legal.service;

import com.z7.legal.bean.User;
import com.z7.legal.common.RequestPram;
import com.z7.legal.common.Result;
import org.apache.lucene.queryparser.classic.ParseException;

import java.io.IOException;
import java.util.List;

/**
 * @Classname UserIndexSearchService
 * @Description TODO 通过索引查询用户信息
 * @Date 2021/4/26 10:36 上午
 * @Author z7-x
 */
public interface UserIndexService {
    /**
     * 启动后将同步User表,并创建index索引库
     *
     * @throws IOException
     */
    void synUserCreatIndex() throws IOException;

    /**
     * 分页
     *
     * @param pageQuery 分页条件
     * @return
     * @throws IOException
     * @throws ParseException
     */
    Result searchUser(RequestPram<User> pageQuery) throws IOException, ParseException;


    /**
     * 查询
     *
     * @param pram
     * @return
     * @throws IOException
     * @throws ParseException
     */
    List<User> searchUser(String pram) throws IOException, ParseException;
}
