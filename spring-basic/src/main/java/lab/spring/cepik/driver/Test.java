package lab.spring.cepik.driver;

import lab.spring.cepik.driver.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@Configurable(preConstruction = true, dependencyCheck = true, autowire = Autowire.BY_TYPE)
public class Test {

    @Autowired
    DriverRepository driverRepository;
}
