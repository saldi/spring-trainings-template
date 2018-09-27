package lab.spring.cepik.driver.events;

import lab.spring.cepik.activity.UserActivity;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class DriverEventsHandler {

    private UserActivity userActivity;

    public DriverEventsHandler(UserActivity userActivity) {
        this.userActivity = userActivity;
    }

    @EventListener
    public void onDriverCreated(DriverCreatedEvent event) {
        userActivity.registerActivity("dodano kierowce hurra " + event.getDriver());
    }


}
