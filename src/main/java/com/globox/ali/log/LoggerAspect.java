package com.globox.ali.log;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
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
public class LoggerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoggerAspect.class);

    private ObjectMapper objectMapper = new ObjectMapper();

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
    }

    @AfterReturning(pointcut = "execution(* com.globox.ali.controller..*(..)) || execution(* com.globox.ali.service..*(..)) || execution(* com.globox.ali.repository..*(..))", returning = "result")
    public void logAfterMethod(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        LogModel logModel = new LogModel();
        logModel.setMethodName(signature.getName());
        logModel.setResponse(result);
        LOGGER.info("Exiting method: {} with result: {}", signature.getName(), logModel.getResponse());
    }


    @Around("execution(* com.globox.ali.controller..*(..)) || execution(* com.globox.ali.service..*(..)) || execution(* com.globox.ali.repository..*(..))")
    public Object logAroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        LogModel logModel = new LogModel();
        logModel.setMethodName(signature.getName());
        logModel.setRequest(proceedingJoinPoint.getArgs());
        Object value = null;
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
        } catch (Throwable e) {
            StringWriter writer = new StringWriter();
            PrintWriter printWriter = new PrintWriter(writer);
            e.printStackTrace(printWriter);
            writer.close();
            printWriter.close();
            logModel.setErrorTrace(writer.toString());
            LOGGER.error("Failure: {}", objectMapper.writeValueAsString(logModel));
            throw e;
        }
        return value;
    }

}
