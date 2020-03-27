
package com.lzycug.mail.config;

import com.lzycug.mail.pojo.Log;
import com.lzycug.mail.service.LogService;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-03-27
 */
@Aspect
@Component
public class SystemLogAspect {
    @Autowired
    private LogService logService;

    // 本地异常日志记录对象
    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    // Service层切点
    @Pointcut("@annotation(com.lzycug.mail.config.SystemServiceLog)")
    public void serviceAspect() {
    }

    @Before("serviceAspect()")
    public void doBefore(JoinPoint joinPoint) {
        String name = joinPoint.getTarget().getClass().getName();
        Log log = new Log();
        log.setLogTime(new Date());
        log.setOperation("发邮件前" + name);
        log.setUserId(001);
        logService.insert(log);
    }

    @After("serviceAspect()")
    public void doAfter(JoinPoint joinPoint) {
        String name = joinPoint.getTarget().getClass().getName();
        Log log = new Log();
        log.setLogTime(new Date());
        log.setOperation("发邮件后" + name);
        log.setUserId(002);
        logService.insert(log);
    }

    @AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        String name = joinPoint.getTarget().getClass().getName();
        Log log = new Log();
        log.setLogTime(new Date());
        log.setOperation("发邮件出错后" + name);
        log.setUserId(003);
        logService.insert(log);
    }
}
