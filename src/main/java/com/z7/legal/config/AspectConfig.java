package com.z7.legal.config;

import com.z7.legal.utils.ApplicationContextUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Classname AspectConfig
 * @Description TODO 切面配置类
 * @Date 2021/4/25 5:56 下午
 * @Author z7-x
 */
@Aspect
@Component
public class AspectConfig {
    private static final Logger logger = LoggerFactory.getLogger(ApplicationContextUtils.class);

    /**
     * 定义一个切入点.
     * 解释下：
     * <p>
     * ~ 第一个 * 代表任意修饰符及任意返回值.
     * ~ 第二个 * 任意包名
     * ~ 第三个 * 代表任意方法.
     * ~ 第四个 * 定义在controller包或者子包
     * ~ 第五个 * 任意方法
     * ~ .. 匹配任意数量的参数.
     */
    @Pointcut(value = "execution(public * com.z7..*.controller..*.*(..))")
    public void log() {
        logger.info("读取aop....");
    }

    /**
     * 前置通知：在切入点之前执行
     *
     * @param joinPoint 可以通过他来获取方法以及参数
     * @Before("log()")
     */
    @Before("log()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            logger.info("前置通知...参数为：" + arg);
        }
    }

    /**
     * 增强处理将：在目标方法正常完成后执行
     *
     * @param returnValue
     * @AfterReturning(value = "log()",returning = "returnValue")
     * returning 获取返回值
     */
    @AfterReturning(value = "log()", returning = "returnValue")
    public void returning(Object returnValue) {
        logger.info("返回通知...结果为：" + returnValue);
    }

}
