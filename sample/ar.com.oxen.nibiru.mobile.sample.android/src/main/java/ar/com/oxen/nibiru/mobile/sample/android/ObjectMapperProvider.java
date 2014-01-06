package ar.com.oxen.nibiru.mobile.sample.android;

import javax.inject.Provider;

import org.codehaus.jackson.Version;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;

import ar.com.oxen.nibiru.mobile.core.api.service.security.LoginDto;
import ar.com.oxen.nibiru.mobile.core.api.service.security.UserDto;
import ar.com.oxen.nibiru.mobile.java.service.security.LoginDtoImpl;
import ar.com.oxen.nibiru.mobile.java.service.security.UserDtoImpl;

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
