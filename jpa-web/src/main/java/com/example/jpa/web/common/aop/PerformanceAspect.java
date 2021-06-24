package com.example.jpa.web.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component  // bean
@Aspect
public class PerformanceAspect {

    // Advice (Around)
    // point cut
    @Around("execution(* com.example.jpa.web.service.*.*(..))")
    public Object logPerf(ProceedingJoinPoint pjp) throws Throwable {

        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        log.info("=========== Log Performance " + (System.currentTimeMillis() - begin));

        return retVal;
    }
}