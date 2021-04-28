package com.z7.legal.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Classname ApplicationContextUtils
 * @Description TODO 获取Bean
 * @Date 2021/4/23 9:43 上午
 * @Author z7-x
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(ApplicationContextUtils.class);

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.info("ApplicationContext正在初始化:   " + applicationContext);
        this.applicationContext = applicationContext;
    }

    /**
     * 根据Class获取工厂中指定的Bean
     *
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> cls) {
        return applicationContext.getBean(cls);
    }

    /**
     * 根据bean名字获取工厂中指定bean 对象
     *
     * @param name
     * @return
     */
    public static <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }
}
