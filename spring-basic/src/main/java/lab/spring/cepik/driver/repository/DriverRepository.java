package lab.spring.cepik.driver.repository;

import lab.spring.cepik.driver.Driver;

import java.util.List;

public interface DriverRepository {

    void save(Driver driver);

    List<Driver> selectAll();


}
