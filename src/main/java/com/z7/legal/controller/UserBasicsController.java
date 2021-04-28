package com.z7.legal.controller;

import com.z7.legal.bean.User;
import com.z7.legal.common.RequestPram;
import com.z7.legal.common.Result;
import com.z7.legal.common.ResultCode;
import com.z7.legal.dao.UserDao;
import com.z7.legal.dao.UserIndexDao;
import com.z7.legal.exception.CustomException;
import com.z7.legal.exception.MutationException;
import com.z7.legal.service.UserIndexService;
import com.z7.legal.service.UserService;
import com.z7.legal.utils.ApplicationContextUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @Classname UserController
 * @Description TODO 基础Restful返回
 * @Date 2021/4/21 11:36 上午
 * @Author z7-x
 */
@RestController
@RequestMapping("/user/basics")
@Api(description = "达梦数据库-模版-用例")
public class UserBasicsController {

    private static final Logger logger = LoggerFactory.getLogger(UserBasicsController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "分页查询", notes = "姓名模糊匹配：查询对应的用户列表")
    @RequestMapping(method = RequestMethod.GET, value = "/findAllPage")
    public Result findAllPage(@ApiParam(value = "请求参数", required = false)
                              @RequestBody RequestPram<User> requestPram) {
        Result<List<User>> result = null;
        Page<User> page = null;
        if (StringUtils.isEmpty(requestPram.getQueryPram())) {
            UserDao userDao = ApplicationContextUtils.getBean(UserDao.class);
            page = userDao.findAll(PageRequest.of(requestPram.getPageNum() - 1, requestPram.getPageSize()));
        } else {
            page = userService.findAllPage(requestPram.getQueryPram().getName(), requestPram.getPageNum(), requestPram.getPageSize());
        }
        result = new Result<>(page.getContent(), new com.z7.legal.common.Page(page.getNumber(), page.getSize(), page.getTotalPages(), page.getTotalElements()));
        return result;
    }

    @ApiOperation(value = "用户列表", notes = "性别分类查询：分页查询所选性别对应的用户列表")
    @RequestMapping(method = RequestMethod.GET, value = "/findAll")
    public Result findAll(@ApiParam(value = "请求参数", required = false)
                          @RequestBody RequestPram<User> requestPram) {
        Result<List<User>> result = null;
        Page<User> page = null;
        if (StringUtils.isEmpty(requestPram.getQueryPram())) {
            UserDao userDao = ApplicationContextUtils.getBean(UserDao.class);
            page = userDao.findAll(PageRequest.of(requestPram.getPageNum() - 1, requestPram.getPageSize()));
        } else {
            page = userService.findAll(requestPram.getQueryPram().getSex(), requestPram.getPageNum(), requestPram.getPageSize());
        }
        result = new Result<>(page.getContent(), new com.z7.legal.common.Page(page.getNumber(), page.getSize(), page.getTotalPages(), page.getTotalElements()));
        return result;
    }

    @ApiOperation(value = "获取用户", notes = "根据id查询用户信息")
    @RequestMapping(method = RequestMethod.GET, value = "/findById")
    public Result findById(@ApiParam(value = "用户id", required = true)
                           @RequestParam String id) {
        return new Result(userService.findUserById(id));
    }

    @ApiOperation(value = "添加用户", notes = "新增用户信息的同时更新索引库用户信息")
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public Result addUser(@ApiParam(value = "用户实体", required = true)
                          @RequestBody User user) throws IOException {
        User u = userService.addUser(user);
        if (!ObjectUtils.isEmpty(u)) {
            UserIndexDao userIndexDao = ApplicationContextUtils.getBean(UserIndexDao.class);
            userIndexDao.addUserIndex(u);
        }
        return new Result(u);
    }

    @ApiOperation(value = "更新用户", notes = "更新用户信息的同时更新索引信息库")
    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public Result updateUser(@ApiParam(value = "用户实体", required = true)
                             @RequestBody User user) {
        if (!ObjectUtils.isEmpty(user.getId())) {
            User u = userService.findUserById(user.getId());
            if (!ObjectUtils.isEmpty(u)) {
                return new Result(userService.updateUser(user));
            }
        }
        return null;
    }

    @ApiOperation(value = "删除用户", notes = "删除用户信息同时删除索引库")
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public Result deleteUser(@ApiParam(value = "用户id", required = true)
                             @RequestParam String... ids) {
        Arrays.stream(ids).forEach(id -> {
            try {
                Boolean bool = userService.deleteUser(id);
                if (true == bool) {
                    UserIndexDao userIndexDao = ApplicationContextUtils.getBean(UserIndexDao.class);
                    userIndexDao.deleteUserIndexById(id);
                }
            } catch (IOException ioException) {
                logger.error("删除用户失败： " + ioException.getMessage());
            }

        });
        return new Result(true);
    }
}
