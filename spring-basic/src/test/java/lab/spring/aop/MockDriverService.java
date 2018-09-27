package lab.spring.aop;

import lab.spring.cepik.driver.Driver;
import lab.spring.cepik.driver.DriverService;

import java.util.List;

public class MockDriverService implements DriverService {
    @Override
    public Driver registerNewDriver(String pesel, String firstName, String lastName, String birthDate) {
        return new Driver();
    }

    @Override
    public List<Driver> selectAll() {
        return null;
    }
}
