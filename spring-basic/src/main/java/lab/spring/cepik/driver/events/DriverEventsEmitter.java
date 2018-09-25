package lab.spring.cepik.driver.events;

import lab.spring.cepik.driver.Driver;

public interface DriverEventsEmitter {

    void onDriverCreated(Driver driver);

}
