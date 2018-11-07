package iocContainer.api;

import java.util.Map;

public interface IocContainer {

    Object resolve(String name) throws Exception;

    Object resolve(Class clazz) throws Exception;

    Map<Class, Object> getRegisteredProperties();

    void register(Class clazz, Object instance);
}
