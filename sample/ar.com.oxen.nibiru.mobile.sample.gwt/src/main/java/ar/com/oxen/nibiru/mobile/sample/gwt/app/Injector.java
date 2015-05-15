package ar.com.oxen.nibiru.mobile.sample.gwt.app;

import ar.com.oxen.nibiru.mobile.gwt.ioc.DefaultGwtHardwareModule;
import ar.com.oxen.nibiru.mobile.gwt.ioc.DefaultGwtModule;
import ar.com.oxen.nibiru.mobile.gwt.ioc.DefaultGwtPlacesModule;
import ar.com.oxen.nibiru.mobile.gwt.ioc.DefaultGwtUiModule;
import ar.com.oxen.nibiru.mobile.gwt.ioc.GwtInjector;

import com.google.gwt.inject.client.GinModules;

@GinModules({ Module.class,
	DefaultGwtModule.class,
	DefaultGwtHardwareModule.class,
	DefaultGwtPlacesModule.class,
	DefaultGwtUiModule.class })
public interface Injector extends GwtInjector {
}
