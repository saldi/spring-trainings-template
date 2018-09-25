package lab.spring.cepik.driver.events;

import lab.spring.cepik.driver.Driver;

public class DriverCreatedEvent {

    private Driver driver;

    public DriverCreatedEvent(Driver driver) {
        this.driver = driver;
    }

    public Driver getDriver() {
        return driver;
    }
}
