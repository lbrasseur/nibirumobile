package ar.com.oxen.nibiru.mobile.gwt.service.security;

import ar.com.oxen.nibiru.mobile.core.api.service.security.LoginDto;
import ar.com.oxen.nibiru.mobile.core.api.service.security.UserDto;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;

public interface AutoBeanDtoFactory extends AutoBeanFactory {
	AutoBean<UserDto> user();

	AutoBean<LoginDto> login();
}
