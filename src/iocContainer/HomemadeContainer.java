package iocContainer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import iocContainer.api.IocContainer;

public class HomemadeContainer implements IocContainer{

	private Map<Class, Object> registeredProperties = new HashMap<>();
	
	@Override
	public void register(Class clazz, Object instance) {
		this.registeredProperties.put(clazz, instance);
	}
	
	@Override
	public Object resolve(Class clazz) throws Exception{
		return registeredProperties.get(clazz);
	}

	@Override
	public Object resolve(String className) throws Exception {
		return this.resolve(Class.forName(className));
	}

	@Override
	public Map<Class, Object> getRegisteredProperties() {
		return Collections.unmodifiableMap(registeredProperties);
	}
	
}
