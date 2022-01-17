package by.itacademy.mikhalevich.icourse.aspect;

import by.itacademy.mikhalevich.icourse.exception.DataBaseErrorException;
import by.itacademy.mikhalevich.icourse.jdbc.EntityManagerHelper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class JpaTransactionAspect {

    private final EntityManagerHelper helper;

    @SneakyThrows
    @Around("@annotation(JpaTransaction)")
    public Object transaction(ProceedingJoinPoint jp){
        log.info("Transaction123 : {}", jp.getSignature().getName());
        Object result = null;
        EntityManager em = null;

        try {
            em = helper.getEntityManager();
            em.getTransaction().begin();

            result = jp.proceed();

            em.getTransaction().commit();
            em.close();

        } catch (Exception e) {
            safeRollback(em, e);
        } finally {
            quietCloseEntityManager(em);
        }
        return result;
    }

    private void safeRollback(EntityManager em, Exception e) {
        log.error(e.getMessage(), e);
        if (em != null) {
            em.getTransaction().rollback();
        }
        throw new DataBaseErrorException(e);
    }

    private void quietCloseEntityManager(EntityManager em) {
        if (em != null) {
            try {
                em.close();
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                //doNothing
            }
        }
    }

}
