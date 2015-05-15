package ar.com.oxen.nibiru.mobile.sample.wp.app;

import ar.com.oxen.nibiru.mobile.gwt.ioc.DefaultGwtHardwareModule;
import ar.com.oxen.nibiru.mobile.gwt.ioc.DefaultGwtModule;
import ar.com.oxen.nibiru.mobile.gwt.ioc.GwtInjector;
import ar.com.oxen.nibiru.mobile.wp.ioc.DefaultWindowsPhoneUiModule;

import com.google.gwt.inject.client.GinModules;

@GinModules({ Module.class,
	DefaultGwtModule.class,
	DefaultGwtHardwareModule.class,
	DefaultWindowsPhoneUiModule.class })
public interface Injector extends GwtInjector {
}
