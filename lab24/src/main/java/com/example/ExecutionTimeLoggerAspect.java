package com.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeLoggerAspect {

    private static final Logger logger = LoggerFactory.getLogger(ExecutionTimeLoggerAspect.class);

    @Around("execution(* com.example.StudentServiceImpl.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        logger.info("Before executing method: {}", joinPoint.getSignature());

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - startTime;
        logger.info("{} executed in {} ms", joinPoint.getSignature(), executionTime);

        logger.info("After executing method: {}", joinPoint.getSignature());

        return proceed;
    }
}
