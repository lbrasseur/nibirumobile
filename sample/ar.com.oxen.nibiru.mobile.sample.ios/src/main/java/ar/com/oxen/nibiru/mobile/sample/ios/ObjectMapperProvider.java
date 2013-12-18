package ar.com.oxen.nibiru.mobile.sample.ios;

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
