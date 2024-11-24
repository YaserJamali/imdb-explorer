package com.globox.ali.log;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.globox.ali.config.FilterWrapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.PrintWriter;
import java.io.StringWriter;


@Aspect
@Component
@RequiredArgsConstructor
public class LoggerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);

    private final ObjectMapper objectMapper;

    private final FilterWrapper filterWrapper;

    @PostConstruct
    public void init() {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }

    @Before("execution(* com.globox.ali.controller..*(..)) || execution(* com.globox.ali.service..*(..)) || execution(* com.globox.ali.repository..*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        LogModel logModel = new LogModel();
        logModel.setMethodName(signature.getName());
        logModel.setRequest(joinPoint.getArgs());
        LOGGER.info("Entering method: {} with arguments: {}", signature.getName(), logModel.getRequest());
        LOGGER.info("HTTP Request Count: {}", filterWrapper.getCounter());
    }

    @AfterReturning(pointcut = "execution(* com.globox.ali.controller..*(..)) || execution(* com.globox.ali.service..*(..)) || execution(* com.globox.ali.repository..*(..))", returning = "result")
    public void logAfterMethod(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        LogModel logModel = new LogModel();
        logModel.setMethodName(signature.getName());
        logModel.setResponse(result);
        LOGGER.info("Exiting method: {} with result: {}", signature.getName(), logModel.getResponse());
        LOGGER.info("HTTP Allow Request Count: {}", filterWrapper.getCounter());
    }

    @Around("execution(* com.globox.ali.controller..*(..)) || execution(* com.globox.ali.service..*(..)) || execution(* com.globox.ali.repository..*(..))")
    public Object logAroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        LogModel logModel = new LogModel();
        logModel.setMethodName(signature.getName());
        logModel.setRequest(proceedingJoinPoint.getArgs());
        Object value;
        try {
            value = proceedingJoinPoint.proceed();
            if (value != null) {
                logModel.setResponse(value);
            }
            if (logModel.getResponse() != null) {
                LOGGER.info("Response: {}", objectMapper.writeValueAsString(logModel.getResponse()));
            } else {
                LOGGER.info("Success: {}", objectMapper.writeValueAsString(logModel));
            }
            LOGGER.info("HTTP Request Count: {}", filterWrapper.getCounter());
        } catch (Throwable e) {
            StringWriter writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            e.printStackTrace(printWriter);
            writer.close();
            printWriter.close();
            logModel.setErrorTrace(writer.toString());
            LOGGER.error("Failure: {}", objectMapper.writeValueAsString(logModel));
            LOGGER.info("HTTP Request Count: {}", filterWrapper.getCounter());
            throw e;
        }
        return value;
    }
}