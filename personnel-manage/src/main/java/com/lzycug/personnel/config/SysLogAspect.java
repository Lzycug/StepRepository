
package com.lzycug.personnel.config;

import com.lzycug.personnel.pojo.SysLog;
import com.lzycug.personnel.service.SysLogService;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-04-03
 */
@Aspect
@Component
public class SysLogAspect {
    @Autowired
    SysLogService sysLogService;

    @Pointcut("@annotation(com.lzycug.personnel.config.Log)")
    public void pointCut() {
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        String methodName = joinPoint.getSignature().getName();
        Date date = new Date();
        int userId = 1002;
        sysLogService.insert(new SysLog(null, userId, methodName + " 异常记录, " + e.getMessage(), date));
    }

    @AfterReturning(pointcut = "pointCut()")
    public void doAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Date date = new Date();
        int userId = 1001;
        sysLogService.insert(new SysLog(null, userId, methodName + " 正常记录", date));
    }
}
