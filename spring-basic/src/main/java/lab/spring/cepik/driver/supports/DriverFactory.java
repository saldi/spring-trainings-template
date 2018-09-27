package lab.spring.cepik.driver.supports;

import lab.spring.cepik.activity.UserActivity;
import lab.spring.cepik.driver.Driver;
import lab.spring.cepik.driver.repository.DriverRepository;
import lab.spring.cepik.driver.repository.JpaDataDriverRepository;
import org.springframework.stereotype.Component;

@Component
public class DriverFactory {

    private JpaDataDriverRepository driverRepository;
    private UserActivity userActivity;

    public DriverFactory(JpaDataDriverRepository driverRepository, UserActivity userActivity) {
        this.driverRepository = driverRepository;
        this.userActivity = userActivity;
    }

    public Driver createDriver(String pesel, String firstName,
                               String lastName, String birthDate) {
        Driver driver = new Driver(pesel, firstName, lastName, birthDate);
        driverRepository.save(driver);
        userActivity.registerActivity("driver factory " + pesel);
        return driver;
    }


}
