package com.z7.legal.service;

import com.z7.legal.bean.User;
import org.springframework.data.domain.Page;

/**
 * @Classname UserService
 * @Description TODO 用户接口
 * @Date 2021/4/21 11:33 上午
 * @Author z7-x
 */
public interface UserService {
    /**
     * 分页查询用户列表
     * 方式一：简单分页查询
     */
    Page<User> findAll(String sex, Integer pageNum, Integer pageSize);

    /**
     * 根据id查询用户信息
     */
    User findUserById(String id);

    /**
     * 分页查询用户列表
     * 方式二：条件分页查询
     */
    Page<User> findAllPage(String name, Integer pageNumber, Integer pageSize);

    /**
     * 添加用户信息
     */
    User addUser(User user);

    /**
     * 删除用户信息
     */
    Boolean deleteUser(String... ids);

    /**
     * 更新用户信息
     *
     * @return
     */
    User updateUser(User user);
}
