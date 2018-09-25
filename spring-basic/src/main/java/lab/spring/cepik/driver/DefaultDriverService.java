package lab.spring.cepik.driver;

import lab.spring.cepik.activity.UserActivity;
import lab.spring.cepik.driver.events.DriverEventsEmitter;
import lab.spring.cepik.driver.supports.DriverFactory;
import org.springframework.stereotype.Service;

@Service
public class DefaultDriverService implements DriverService {

    private DriverFactory driverFactory;

    private DriverEventsEmitter eventsEmitter;

    public DefaultDriverService(DriverFactory driverFactory, DriverEventsEmitter eventsEmitter) {
        this.driverFactory = driverFactory;
        this.eventsEmitter = eventsEmitter;
    }

    public Driver registerNewDriver(String pesel, String firstName, String lastName, String birthDate) {

        Driver driver = driverFactory.createDriver(pesel, firstName, lastName, birthDate);
        eventsEmitter.onDriverCreated(driver);
        return driver;
    }


}
