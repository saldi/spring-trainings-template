package lab.spring.cepik.driver;

import lab.spring.cepik.activity.UserActivity;
import lab.spring.cepik.driver.supports.DriverFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.function.Supplier;

public class DefaultDriverService implements DriverService {

    private DriverFactory driverFactory;
    private Supplier<UserActivity> userActivity;


    public DefaultDriverService(DriverFactory driverFactory, Supplier<UserActivity> userActivity) {
        this.driverFactory = driverFactory;
        this.userActivity = userActivity;
    }

    public Driver registerNewDriver(String pesel, String firstName, String lastName, String birthDate) {
        userActivity.get().registerActivity("register activity " + pesel);
        return driverFactory.createDriver(pesel, firstName, lastName, birthDate);
    }
}
