package lab.spring.cepik.aspect;


import lab.spring.cepik.driver.Driver;
import lab.spring.cepik.driver.events.DriverEventsEmitter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DriverAspect {

    DriverEventsEmitter driverEventsEmitter;

    public DriverAspect(DriverEventsEmitter driverEventsEmitter) {
        this.driverEventsEmitter = driverEventsEmitter;
    }

    @Around(value = "execution(* lab.spring.cepik.driver.DriverService.registerNewDriver(..))")
    public Object driverCreating(ProceedingJoinPoint pjp) {

        try {
            Object driver = pjp.proceed();
            driverEventsEmitter.onDriverCreated((Driver) driver);
            return driver;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;

    }


}
