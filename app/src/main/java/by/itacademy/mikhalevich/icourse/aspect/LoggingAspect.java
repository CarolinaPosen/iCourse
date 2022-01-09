package by.itacademy.mikhalevich.icourse.aspect;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Optional;

@Aspect
@Slf4j
@Component
public class LoggingAspect {

    @Pointcut("execution(* by.itacademy.mikhalevich.icourse.api.*.*(..))")
    public void controllers() {
        //pointcut
    }

    @Before("controllers()")
    public void before(JoinPoint jp) {
//        Arrays.stream(jp.getArgs()).forEach(arg -> log.info(arg.toString()));
//        log.info("Logging before controller`s method {}", jp.getSignature().getName());

//        Arrays.stream(jp.getArgs())
//                .filter(arg -> arg instanceof HttpServletRequest)
//                .findAny()
//                .map(arg -> (HttpServletRequest) arg)
//                .ifPresent(req -> log.info("Request {}, {}", req.getMethod(), ServletUriComponentsBuilder.fromRequest(req).toUriString()));

    }

    //    @After("controllers()")
    public void after(JoinPoint jp) {
        log.info("Logging after controller`s method {}", jp.getSignature().getName());
    }

    @SneakyThrows
//    @Around("controllers()")
    public Object around(ProceedingJoinPoint jp) {
        log.info("Logging around before method {}", jp.getSignature().getName());
        log.info(jp.getKind());
        log.info(jp.toLongString());
        log.info(jp.toShortString());
        Arrays.stream(jp.getArgs()).forEach(System.out::println);
        log.info(jp.getStaticPart().toLongString());
        log.info(jp.getThis().toString());
        Object result = jp.proceed();
        log.info("Logging around after method {}", jp.getSignature().getName());
        return result;
    }

    @SneakyThrows
//    @Around("@annotation(Testing)")
    public Object transaction(ProceedingJoinPoint jp) {
        log.info("Testing123 : {}", jp.getSignature().getName());
        Object result = jp.proceed();
        return result;
    }

}
