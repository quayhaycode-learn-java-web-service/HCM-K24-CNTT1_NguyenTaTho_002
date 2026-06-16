package com.reptithcm.edu.kiemtrahackathon.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("@annotation( org.springframework.transaction.annotation.Transactional)")
    public void loggingBeforeTransaction(JoinPoint joinPoint){
        log.info(joinPoint.getSignature().getName() + ": starting");
    }


}
