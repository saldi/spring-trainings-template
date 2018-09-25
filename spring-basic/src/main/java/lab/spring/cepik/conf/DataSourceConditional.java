package lab.spring.cepik.conf;

import lab.spring.cepik.driver.supports.DataSourceCondition;
import org.springframework.context.annotation.Conditional;

@Conditional({DataSourceCondition.class})
public @interface DataSourceConditional {
}
