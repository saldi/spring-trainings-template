package lab.spring.cepik.activity;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.core.NamedThreadLocal;

public class ActivityScope implements Scope {

    private NamedThreadLocal<UserActivity>
            threadLocal = new NamedThreadLocal<>(ActivityScope.class.getName());

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        UserActivity userActivity = threadLocal.get();
        if (userActivity == null) {
            userActivity = (UserActivity) objectFactory.getObject();
            threadLocal.set(userActivity);
        }
        return userActivity;
    }

    @Override
    public Object remove(String name) {
        UserActivity userActivity = threadLocal.get();
        threadLocal.remove();
        return true;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return Thread.currentThread()
                .getName();
    }
}
