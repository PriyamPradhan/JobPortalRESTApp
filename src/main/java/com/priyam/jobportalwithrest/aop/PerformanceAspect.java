package com.priyam.jobportalwithrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {

    //added logger
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceAspect.class);

    @Around("execution(* com.priyam.jobportalwithrest.service.JobService.getAllJobs(..))")             //around advice
    public Object monitorTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object obj = joinPoint.proceed();                                                               //need to return an object for Around advice

        long endTime = System.currentTimeMillis();

        LOGGER.info("Time taken for " + joinPoint.getSignature().getName() + " to process execution time: " + (endTime - startTime) + "ms");

    return obj;
    }
}
