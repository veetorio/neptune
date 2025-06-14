package com.example.api.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggerWatcherAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggerWatcherAspect.class);

    private static long time;
    @Before("@within(loggerWatcher)")
    public void logAntesDosMetodos(JoinPoint joinPoint, LoggerWatcher loggerWatcher) {
        String nomeClasse = joinPoint.getTarget().getClass().getSimpleName();
        String nomeMetodo = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        time = System.currentTimeMillis();

        logger.info("A rota : {}.{} foi acessada com argumentos: {}",
                nomeClasse, nomeMetodo, Arrays.toString(args));
    }
    @After("@within(loggerWatcher)")
    public void logDepoisDoMetodo(JoinPoint joinPoint, LoggerWatcher loggerWatcher) {
        String nomeMetodo = joinPoint.getSignature().getName();
        long timeEnd = System.currentTimeMillis() - time;

        logger.info("A thread {} e foi encerrada em {}ms",nomeMetodo,timeEnd);
    }


    @AfterThrowing(pointcut = "@within(loggerWatcher)", throwing = "ex")
    public void logErros(JoinPoint joinPoint, LoggerWatcher loggerWatcher, Throwable ex) {
        String nomeMetodo = joinPoint.getSignature().getName();
        logger.error("❌ Exceção no método {}: {}", nomeMetodo, ex.getMessage(), ex);
    }


}

