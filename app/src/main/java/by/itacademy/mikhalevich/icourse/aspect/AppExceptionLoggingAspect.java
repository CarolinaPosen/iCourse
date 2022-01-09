package by.itacademy.mikhalevich.icourse.aspect;

import by.itacademy.mikhalevich.icourse.exception.ControllerException;
import by.itacademy.mikhalevich.icourse.exception.DataBaseErrorException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AppExceptionLoggingAspect {

    @AfterThrowing(
            pointcut = "execution(* by.itacademy.mikhalevich.icourse.spring.AbstractRepositoryOrmImpl.findAll())",
            throwing = "ex"
    )
    public void ControllerException(Exception ex){
        log.error("Exception {}", ex.getMessage());
        throw new ControllerException(ex);
    }

    @AfterThrowing(
            pointcut = "execution(* by.itacademy.mikhalevich.icourse.spring.AbstractRepositoryOrmImpl.findAll())",
            throwing = "ex"
    )
    public void RepositoryException(Exception ex){
        log.error("Exception {}", ex.getMessage());
        throw new DataBaseErrorException(ex);
    }

}
