package com.priyam.jobportalwithrest.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.priyam.jobportalwithrest.service.JobService.getJob(..)) && args(postId)")
    public Object validationAspect(ProceedingJoinPoint pjp, int postId) throws Throwable {


        if(postId < 0){
            LOGGER.info("PostId is negative, hence updating it");
            postId = postId * -1;
            LOGGER.info("PostId new value is " + postId);
        }
        Object obj1 = pjp.proceed(new Object[]{postId});

        return obj1;
    }

}
