package com.z7.legal.init;

import com.z7.legal.service.UserIndexService;
import com.z7.legal.utils.ApplicationContextUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 项目启动后,立即执行
 * ToDo 创建结构化索引库
 *
 * @author z7-x
 */
@Component
@Order(value = 1)
public class CreateIndexRunner implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationContextUtils.class);

    @Autowired
    private UserIndexService userIndexService;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        logger.info("开始创建创建索引库...");
        long startTime = System.currentTimeMillis();
        try {
            userIndexService.synUserCreatIndex();
        } catch (Exception e) {
            logger.error("创建索引库失败： " + e.getMessage());
        } finally {
            long endTime = System.currentTimeMillis();
            logger.info("创建索引库共消耗:  " + (endTime - startTime) + "ms");
        }
    }
}
