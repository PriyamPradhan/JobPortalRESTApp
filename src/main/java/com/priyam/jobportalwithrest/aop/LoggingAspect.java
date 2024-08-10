package com.priyam.jobportalwithrest.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {


    //logger
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // return type, class-name.method-name(args)

    @Before("execution(* com.priyam.jobportalwithrest.service.JobService.*(..))")
    public void onMethodCall(){
    //    System.out.println("onMethodCall");
        LOGGER.info("Method called");
    }
}
