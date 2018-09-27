package lab.spring.cepik.driver;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DriverService {


    Driver registerNewDriver(String pesel, String firstName, String lastName, String birthDate);

    List<Driver> selectAll();

}
