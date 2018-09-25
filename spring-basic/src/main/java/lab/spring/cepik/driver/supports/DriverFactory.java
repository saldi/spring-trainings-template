package lab.spring.cepik.driver.supports;

import lab.spring.cepik.activity.UserActivity;
import lab.spring.cepik.driver.Driver;
import lab.spring.cepik.driver.repository.DriverRepository;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class DriverFactory {

    private DriverRepository driverRepository;
    private Supplier<UserActivity> userActivity;

    public DriverFactory(DriverRepository driverRepository, Supplier<UserActivity> userActivity) {
        this.driverRepository = driverRepository;
        this.userActivity = userActivity;
    }

    public Driver createDriver(String pesel, String firstName,
                               String lastName, String birthDate) {
        Driver driver = new Driver(pesel, firstName, lastName, birthDate);
        userActivity.get()
                .registerActivity("driver factory " + pesel);
        return driver;
    }


}
