package com.priyam.jobportalwithrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect                 //Aspect AOP
public class LoggingAspect {


    //logger
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // return type, class-name.method-name(args)

    //Advice                                //PointCut
    @Before("execution(* com.priyam.jobportalwithrest.service.JobService.getAllJobs(..)) || execution(* com.priyam.jobportalwithrest.service.JobService.getJob(..))")
    public void onMethodCall(JoinPoint jp){             //join Point
        LOGGER.info("Method called : " + jp.getSignature().getName());
    }
}
