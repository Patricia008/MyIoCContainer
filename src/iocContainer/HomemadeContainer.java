package iocContainer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import iocContainer.api.IocContainer;

public class HomemadeContainer implements IocContainer{

	private Map<String, Class> registeredProperties = new HashMap<>();
	
	@Override
	public <T> void register(String propertyName, Class<T> clazz) {
		this.registeredProperties.put(propertyName, clazz);
	}
	
	@Override
	public <T> T resolve(String propertyName) throws Exception{
		Class<? extends T> bean = (Class<? extends T>) registeredProperties.get(propertyName);
		
		try {
			return bean.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new Exception(e);
		}
	}

	@Override
	public <T> T resolve(Class<? extends T> clazz) throws Exception {
		return this.resolve(clazz.getSimpleName());
	}

	@Override
	public Map<String, Object> getRegisteredProperties() {
		return Collections.unmodifiableMap(registeredProperties);
	}
	
}
