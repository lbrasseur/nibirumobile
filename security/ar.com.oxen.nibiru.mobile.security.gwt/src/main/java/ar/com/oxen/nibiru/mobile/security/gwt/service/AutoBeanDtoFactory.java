package ar.com.oxen.nibiru.mobile.security.gwt.service;

import ar.com.oxen.nibiru.mobile.security.core.api.service.LoginDto;
import ar.com.oxen.nibiru.mobile.security.core.api.service.UserDto;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;

public interface AutoBeanDtoFactory extends AutoBeanFactory {
	AutoBean<UserDto> user();

	AutoBean<LoginDto> login();
}
