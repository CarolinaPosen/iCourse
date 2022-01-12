package by.itacademy.mikhalevich.icourse.aspect;

import by.itacademy.mikhalevich.icourse.exception.ControllerErrorException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ControllerExceptionAspect {

    @AfterThrowing(
            pointcut = "execution(* by.itacademy.mikhalevich.icourse.api.*.*(..)))",
            throwing = "ex"
    )
    public void controllerException(Exception ex){
        log.error("Controller Exception {}", ex.getMessage());
        throw new ControllerErrorException(ex);
    }

}
