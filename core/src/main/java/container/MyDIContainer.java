package container;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyDIContainer {

    private Map<Class, Object> objects =
            new HashMap<Class, Object>();

    public MyDIContainer(String basePackage) {
        Reflections reflections = new Reflections(basePackage);
        reflections.getTypesAnnotatedWith(Component.class)
                .stream().forEach(clazz -> resolve(clazz));
    }

    private Object resolve(Class<?> clazz) {

        if (objects.containsKey(clazz)) {
            return objects.get(clazz);
        }

        Constructor<?> constructor = clazz.getConstructors()[0];

        try {
            Class<?>[] types = constructor.getParameterTypes();
            Object[] objects = Arrays.stream(types).map(this::resolve).toArray();
            Object obj = constructor.newInstance(objects);
            this.objects.put(clazz, obj);
            return obj;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public <T> T getObject(Class<T> clazz) {
        return (T) this.resolve(clazz);
    }

}
