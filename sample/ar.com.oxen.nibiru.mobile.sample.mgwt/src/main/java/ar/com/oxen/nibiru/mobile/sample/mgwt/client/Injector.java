package ar.com.oxen.nibiru.mobile.sample.mgwt.client;

import ar.com.oxen.nibiru.mobile.gwt.ioc.DefaultGwtHardwareModule;
import ar.com.oxen.nibiru.mobile.gwt.ioc.DefaultGwtModule;
import ar.com.oxen.nibiru.mobile.gwt.ioc.DefaultGwtPlacesModule;
import ar.com.oxen.nibiru.mobile.security.gwt.ioc.DefaultSecurityModule;
import ar.com.oxen.nibiru.mobile.gwt.ioc.GwtInjector;
import ar.com.oxen.nibiru.mobile.mgwt.ioc.DefaultMgwtUiModule;
import ar.com.oxen.nibiru.mobile.security.mgwt.ioc.DefaultMgwtSecurityModule;

import com.google.gwt.inject.client.GinModules;

@GinModules({ Module.class, DefaultGwtModule.class,
		DefaultGwtHardwareModule.class, DefaultGwtPlacesModule.class,
		DefaultMgwtUiModule.class, DefaultSecurityModule.class,
		DefaultMgwtSecurityModule.class })
public interface Injector extends GwtInjector {
}
