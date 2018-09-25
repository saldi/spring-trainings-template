package lab.spring.cepik.driver.supports;


import org.springframework.beans.BeansException;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import javax.sql.DataSource;

public class DataSourceUnavailableCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext,
                           AnnotatedTypeMetadata annotatedTypeMetadata) {
        DataSource dataSource = null;
        try {
            dataSource = conditionContext.getBeanFactory()
                    .getBean(DataSource.class);
            return false;
        } catch (BeansException e) {
            return true;
        }
    }
}
