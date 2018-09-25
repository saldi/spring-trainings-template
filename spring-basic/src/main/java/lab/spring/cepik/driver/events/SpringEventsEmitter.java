package lab.spring.cepik.driver.events;

import lab.spring.cepik.driver.Driver;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class SpringEventsEmitter implements DriverEventsEmitter {

    private ApplicationEventPublisher publisher;

    public SpringEventsEmitter(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void onDriverCreated(Driver driver) {
        publisher.publishEvent(new DriverCreatedEvent(driver));
    }
}
