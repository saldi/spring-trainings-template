package lab.spring.cepik.driver;

import lab.spring.cepik.activity.UserActivity;
import lab.spring.cepik.conf.CepikConfiguration;
import lab.spring.cepik.conf.Profiles;
import lab.spring.cepik.driver.supports.PropertiesExample;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SimpleDriverServiceTest {

    AnnotationConfigApplicationContext ctx;

    @BeforeMethod
    public void setUp() {
        System.setProperty("spring.profiles.active", Profiles.DEV);
        ctx = new AnnotationConfigApplicationContext(CepikConfiguration.class);
    }

    @Test
    public void createContainerTest() {
        DriverService driverService = ctx.getBean(DriverService.class);
        Assert.assertNotNull(driverService);
    }

    @Test
    public void createDriverTest() {
        Driver driver = ctx.getBean(DriverService.class)
                .registerNewDriver("44444444444", "Jan", "Kowalski", "1950/01/01");
        Assert.assertNotNull(driver);
        Assert.assertEquals(driver.getPesel(), "44444444444");
    }

    @Test
    public void selectAllTest(){
        DriverService service = ctx.getBean(DriverService.class);
        List<Driver> drivers = service.selectAll();
        Assert.assertNotNull(drivers);
        drivers.stream().forEach(driver -> {
            System.out.println(driver);
        });
    }


    @Test
    public void activityTest() throws InterruptedException {

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new ActivitySampler());
        }

        for (int i = 0; i < 5; i++) {
            threads[i].start();
        }

        TimeUnit.SECONDS.sleep(5);

    }


    class ActivitySampler implements Runnable {

        @Override
        public void run() {

            String pesel = String.valueOf(new Random().nextInt(1000000000));

            UserActivity userActivity = ctx.getBean(UserActivity.class);
            userActivity.registerActivity("START " + Thread.currentThread()
                    .getName());
            Driver driver = ctx.getBean(DriverService.class)
                    .registerNewDriver(pesel, "Jan", "Kowalski", "1950/01/01");

            userActivity.registerActivity("STOP " + Thread.currentThread()
                    .getName());

            userActivity = ctx.getBean(UserActivity.class);
            userActivity.getActivities()
                    .stream()
                    .forEach(activity -> {
                        System.out.println(activity.getMessage());
                    });

            userActivity.clear();
        }
    }

    @Test
    public void PropertiesTest() {
        String message = ctx.getBean(PropertiesExample.class)
                .getMessage();
        System.out.println(message);
    }

}
