package lab.spring.cepik.driver.events;

import lab.spring.cepik.activity.UserActivity;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class DriverEventsHandler {

    private Supplier<UserActivity> userActivity;

    public DriverEventsHandler(Supplier<UserActivity> userActivity) {
        this.userActivity = userActivity;
    }

    @EventListener
    public void onDriverCreated(DriverCreatedEvent event) {
        System.out.println("dodano kierowce " + event.getDriver());
    }


}
