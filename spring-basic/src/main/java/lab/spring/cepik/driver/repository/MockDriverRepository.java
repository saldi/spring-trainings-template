package lab.spring.cepik.driver.repository;

import lab.spring.cepik.conf.DataSourceConditional;
import lab.spring.cepik.conf.DataSourceUnvailable;
import lab.spring.cepik.conf.Profiles;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
public class MockDriverRepository implements DriverRepository {


    public MockDriverRepository() {
        System.out.println("MOCK REPOSITORY");
    }
}
