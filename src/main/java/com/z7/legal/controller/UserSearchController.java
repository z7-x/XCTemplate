package com.z7.legal.controller;

import com.z7.legal.bean.User;
import com.z7.legal.common.RequestPram;
import com.z7.legal.common.Result;
import com.z7.legal.service.UserIndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @Classname UserIndexController
 * @Description TODO 用户检索
 * @Date 2021/4/26 3:11 下午
 * @Author z7-x
 */
@RestController
@RequestMapping("/user/search")
@Api(description = "达梦数据库-模版-用例")
public class UserSearchController {

    @Autowired
    private UserIndexService userIndexService;

    @ApiOperation(value = "检索用户", notes = "根据描叙信息检索对应的用户信息")
    @RequestMapping(value = "/describe", method = RequestMethod.GET)
    private Result searchUser(@RequestParam String param) throws IOException, ParseException {
        List<User> users = userIndexService.searchUser(param);
        return new Result(users);
    }

    @ApiOperation(value = "检索用户", notes = "根据传入参数查询符合条件的用户信息")
    @RequestMapping(value = "/params", method = RequestMethod.GET)
    private Result param(@RequestBody RequestPram<User> pram) throws IOException, ParseException {
        return new Result(userIndexService.searchUser(pram));
    }

}
