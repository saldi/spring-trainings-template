package lab.spring.aop;

import lab.spring.cepik.driver.DriverService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class DriverInvocationHandler implements InvocationHandler {

    private DriverService driverService;

    public DriverInvocationHandler(DriverService driverService) {
        this.driverService = driverService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Arrays.stream(args)
                .forEach(arg -> System.out.println("arg.getClass().getName() = " + arg.getClass()
                        .getName()));
        Object invoke = method.invoke(driverService, args);

        System.out.println("Zwracane "+invoke);

        return invoke;
    }
}
