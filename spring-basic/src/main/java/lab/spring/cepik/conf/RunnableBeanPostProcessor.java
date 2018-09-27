package lab.spring.cepik.conf;

import lab.spring.cepik.driver.Driver;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.concurrent.ExecutorService;

public class RunnableBeanPostProcessor implements BeanPostProcessor {

    private ExecutorService executorService;

    public RunnableBeanPostProcessor(ExecutorService executorService) {
        this.executorService = executorService;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (isBeanRunnable(bean)) {
            Runnable runnable = (Runnable) bean;
            executorService.submit(runnable);
        }

        return bean;
    }

    private boolean isBeanRunnable(Object bean) {
        return Runnable.class.isAssignableFrom(bean.getClass());
    }
}
