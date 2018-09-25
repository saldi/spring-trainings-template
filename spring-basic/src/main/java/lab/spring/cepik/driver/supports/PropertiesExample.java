package lab.spring.cepik.driver.supports;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesExample {

    @Value("${app.name}")
    private String appName;

    @Value("${app.localization}")
    private String city;

    public String getMessage() {
        return appName + " " + city;
    }


}
