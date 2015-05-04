package ar.com.oxen.nibiru.mobile.sample.android.app;

import javax.inject.Provider;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;

import ar.com.oxen.nibiru.mobile.security.core.api.service.LoginDto;
import ar.com.oxen.nibiru.mobile.security.core.api.service.UserDto;
import ar.com.oxen.nibiru.mobile.security.java.service.LoginDtoImpl;
import ar.com.oxen.nibiru.mobile.security.java.service.UserDtoImpl;

public class ObjectMapperProvider implements Provider<ObjectMapper> {

	@Override
	public ObjectMapper get() {
		// TODO: Este codigo esta duplicado, podria ir en alguna clase generica
		SimpleModule jacksonModule = new SimpleModule("NibiruSample",
				new Version(1, 0, 0, "SNAPSHOT"));
		jacksonModule
				.addAbstractTypeMapping(LoginDto.class, LoginDtoImpl.class);
		jacksonModule.addAbstractTypeMapping(UserDto.class, UserDtoImpl.class);

		ObjectMapper jacksonMapper = new ObjectMapper();
		jacksonMapper.registerModule(jacksonModule);
		return jacksonMapper;
	}

}
