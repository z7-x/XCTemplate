package com.z7.legal.service.impl;

import com.z7.legal.bean.User;
import com.z7.legal.dao.UserDao;
import com.z7.legal.service.UserService;
import com.z7.legal.utils.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2021/4/21 11:34 上午
 * @Author z7-x
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<User> findAll(String sex, Integer pageNum, Integer pageSize) {
        User user = User.builder().sex(sex).build();
        ExampleMatcher matcher = ExampleMatcher.matching()
//                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith()) //模糊查询匹配开头，即{name}%
//                .withMatcher("phone", ExampleMatcher.GenericPropertyMatchers.contains())  //全部模糊查询，即%{address}%
//                .withIgnorePaths("sex") //忽略字段，即不管password是什么值都不加入查询条件
                .withMatcher("sex", ExampleMatcher.GenericPropertyMatchers.exact());//精确查询，即{sex='M'}
        Example<User> example = Example.of(user, matcher);
        Page<User> page = userDao.findAll(example,
                PageRequest.of(pageNum - 1, pageSize, Sort.by(Sort.Direction.DESC, "id")));
        return page;
    }

    @Override
    public User findUserById(String id) {
        Optional<User> user = userDao.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        return null;
    }

    @Override
    public Page<User> findAllPage(String name, Integer pageNumber, Integer pageSize) {
        Page<User> userList = null;
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize, Sort.by(Sort.Direction.DESC, "id"));
        userList = userDao.findByNameLikePage("%" + name + "%", pageable);
        return userList;
    }

    @Override
    public User addUser(User user) {
        user.setId(new ObjectId().toHexString());
        return userDao.save(user);
    }

    @Override
    public Boolean deleteUser(String... ids) {
        Arrays.stream(ids).forEach(id -> {
            userDao.deleteById(id);
        });
        return true;
    }

    @Override
    public User updateUser(User user) {
        return userDao.save(user);
    }
}
