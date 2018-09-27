package lab.spring.cepik.driver.repository;

import lab.spring.cepik.conf.DataSourceConditional;
import lab.spring.cepik.conf.DataSourceUnvailable;
import lab.spring.cepik.conf.Profiles;
import lab.spring.cepik.driver.Driver;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MockDriverRepository implements DriverRepository {


    public MockDriverRepository() {
        System.out.println("MOCK REPOSITORY");
    }

    @Override
    public void save(Driver driver) {

    }

    @Override
    public List<Driver> selectAll() {
        return null;
    }
}
