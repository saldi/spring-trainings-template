package lab.spring.cepik.driver.conf;

import lab.spring.cepik.activity.ActivityScope;
import lab.spring.cepik.activity.UserActivity;
import lab.spring.cepik.driver.DefaultDriverService;
import lab.spring.cepik.driver.DriverService;
import lab.spring.cepik.driver.supports.DriverFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.*;

import java.util.function.Supplier;

@Configuration
@ComponentScan(basePackages = {"lab.spring.cepik.driver.supports",
        "lab.spring.cepik.driver.repository"}, scopedProxy = ScopedProxyMode.TARGET_CLASS)
@PropertySource({"/lab/spring/app.properties"})
public class DriverConfiguration {

    @Bean
    @Scope("activity")
    public UserActivity userActivity() {
        return new UserActivity();
    }


    @Bean
    public Supplier<UserActivity> userActivitySupplier() {
        return () -> {
            return userActivity();
        };
    }

    @Bean
    public static CustomScopeConfigurer customScopeConfigurer() {
        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        customScopeConfigurer.addScope("activity", new ActivityScope());
        return customScopeConfigurer;
    }

    @Autowired
    private DriverFactory driverFactory;


    @Bean
    public DriverService defaultDriverService() {
        return new DefaultDriverService(driverFactory, userActivitySupplier());
    }


}
