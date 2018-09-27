package lab.spring.conf;

import lab.spring.cepik.conf.CepikConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"lab.spring.app"})
@Import({CepikConfiguration.class})
public class ApplicationConfiguration {


}
