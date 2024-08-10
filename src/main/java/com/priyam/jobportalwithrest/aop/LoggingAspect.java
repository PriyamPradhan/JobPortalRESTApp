package com.priyam.jobportalwithrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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

    @After("execution(* com.priyam.jobportalwithrest.service.JobService.getAllJobs(..)) || execution(* com.priyam.jobportalwithrest.service.JobService.getJob(..))")
    public void logMethodExecuted(JoinPoint jp){             //join Point
        LOGGER.info("Method Executed : " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.priyam.jobportalwithrest.service.JobService.getAllJobs(..)) || execution(* com.priyam.jobportalwithrest.service.JobService.getJob(..))")
    public void logMethodCrash(JoinPoint jp){             //join Point
        LOGGER.info("Method has some issues : " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.priyam.jobportalwithrest.service.JobService.getAllJobs(..)) || execution(* com.priyam.jobportalwithrest.service.JobService.getJob(..))")
    public void logMethodSuccess(JoinPoint jp){             //join Point
        LOGGER.info("Method executed successfully : " + jp.getSignature().getName());
    }

}
