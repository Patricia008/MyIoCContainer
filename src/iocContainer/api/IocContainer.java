package iocContainer.api;

import java.util.Map;

public interface IocContainer {

    <T> T resolve(String name) throws Exception;

    <T> T resolve(Class<? extends T> clazz) throws Exception;

    Map<String, Object> getRegisteredProperties();

    <T> void register(String beanName, Class<T> clazz);
}
