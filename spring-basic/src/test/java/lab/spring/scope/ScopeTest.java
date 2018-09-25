package lab.spring.scope;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

public class ScopeTest {

    @Test
    public void simpleScopeTest() {

        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(SimpleSpringConfig.class);
        Car car = ctx.getBean(Car.class);
        System.out.println(car);


    }


}
