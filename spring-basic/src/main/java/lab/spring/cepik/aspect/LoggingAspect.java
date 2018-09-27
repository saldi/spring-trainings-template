package lab.spring.cepik.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {


    @Around(value = "@annotation(Log)")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        Class<?> aClass = pjp.getTarget()
                .getClass();
        Object[] args = pjp.getArgs();
        String methodName = pjp.getSignature()
                .getName();

        LogManager.getLogger(aClass)
                .info(() -> "Uruchomiono metodę o nazwie " + methodName);

        try {
            return pjp.proceed();
        } catch (Throwable throwable) {
            LogManager.getLogger(aClass)
                    .error(() -> throwable);
            throw throwable;
        }
    }


}
