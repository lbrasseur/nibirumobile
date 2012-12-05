package ar.com.oxen.nibiru.mobile.sample.smartgwt.client;

import ar.com.oxen.nibiru.mobile.gwt.ioc.DefaultGwtHardwareModule;
import ar.com.oxen.nibiru.mobile.gwt.ioc.DefaultGwtModule;
import ar.com.oxen.nibiru.mobile.gwt.ioc.DefaultSecurityModule;
import ar.com.oxen.nibiru.mobile.gwt.ioc.GwtInjector;
import ar.com.oxen.nibiru.mobile.smartgwt.ioc.DefaultSmartGwtUiModule;

import com.google.gwt.inject.client.GinModules;

@GinModules({ Module.class, DefaultGwtModule.class,
		DefaultGwtHardwareModule.class, DefaultSmartGwtUiModule.class,
		DefaultSecurityModule.class })
public interface Injector extends GwtInjector {
}
