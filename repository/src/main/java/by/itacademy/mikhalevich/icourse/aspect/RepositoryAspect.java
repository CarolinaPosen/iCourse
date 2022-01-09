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

@Aspect
@Slf4j
@Component
public class RepositoryAspect {

//    @Pointcut("execution(* by.itacademy.mikhalevich.icourse.orm.*.*(..))")
    public void repositories(){
        //pointcut
    }

//    @Before("repositories()")
    public void before(JoinPoint jp){
        log.info("Logging before repositories method {}", jp.getSignature().getName());
    }

//    @After("controllers()")
    public void after(JoinPoint jp){
        log.info("Logging after controller`s method {}", jp.getSignature().getName());
    }

    @SneakyThrows
//    @Around("execution(* by.itacademy.mikhalevich.icourse.orm.AbstractRepositoryOrmImpl.findAll(..))")
    public Object transaction(ProceedingJoinPoint jp){
        log.info("RepositoryTestingTesting123 : {}", jp.getSignature().getName());
        Object result = jp.proceed();
        return result;
    }

}
