package lab.spring.cepik.driver.supports;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import javax.sql.DataSource;

public class DataSourceCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext,
                           AnnotatedTypeMetadata annotatedTypeMetadata) {

        BeanDefinition definition = conditionContext.getRegistry()
                .getBeanDefinition(
                        "dataSource");
        return definition == null ? true : false;
    }
}
