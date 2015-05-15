package ar.com.oxen.nibiru.mobile.sample.mgwt.app;

import ar.com.oxen.nibiru.mobile.gwt.ioc.DefaultGwtHardwareModule;
import ar.com.oxen.nibiru.mobile.gwt.ioc.DefaultGwtModule;
import ar.com.oxen.nibiru.mobile.gwt.ioc.DefaultGwtPlacesModule;
import ar.com.oxen.nibiru.mobile.gwt.ioc.GwtInjector;
import ar.com.oxen.nibiru.mobile.mgwt.ioc.DefaultMgwtUiModule;

import com.google.gwt.inject.client.GinModules;

@GinModules({ Module.class,
	DefaultGwtModule.class,
	DefaultGwtHardwareModule.class,
	DefaultGwtPlacesModule.class,
	DefaultMgwtUiModule.class })
public interface Injector extends GwtInjector {
}
