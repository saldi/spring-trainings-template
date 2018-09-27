package lab.spring.aop;

import lab.spring.cepik.driver.Driver;
import lab.spring.cepik.driver.DriverService;
import org.testng.annotations.Test;

import java.lang.reflect.Proxy;

public class ProxyTest {


    @Test
    public void createProxyTest() {

        DriverService driverService = new MockDriverService();
        DriverInvocationHandler handler = new DriverInvocationHandler(driverService);

        DriverService proxiedDriverService =
                (DriverService) Proxy.newProxyInstance(Thread.currentThread()
                                .getContextClassLoader(),
                        new Class[]{DriverService.class}, handler);

        Driver driver = proxiedDriverService.registerNewDriver("33333333333", "Jerzy", "Kwiatkowski", "2000/01/01");
        System.out.println(driver);

    }


}
