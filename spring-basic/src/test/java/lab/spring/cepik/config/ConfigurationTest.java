package lab.spring.cepik.config;

import lab.spring.cepik.conf.CepikConfiguration;
import lab.spring.cepik.conf.Profiles;
import lab.spring.cepik.driver.DriverService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ConfigurationTest {

    ApplicationContext ctx;

    @BeforeMethod
    public void setUp() {
        System.setProperty("spring.profiles.active", Profiles.DEV);
        ctx = new AnnotationConfigApplicationContext(CepikConfiguration.class);
    }

    @Test
    public void configurationTest() {
        DriverService driverService = ctx.getBean(DriverService.class);
        Assert.assertNotNull(driverService);
    }


}
