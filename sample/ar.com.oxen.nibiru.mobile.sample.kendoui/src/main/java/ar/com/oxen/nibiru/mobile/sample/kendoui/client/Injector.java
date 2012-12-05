package ar.com.oxen.nibiru.mobile.sample.kendoui.client;

import ar.com.oxen.nibiru.mobile.gwt.ioc.DefaultGwtHardwareModule;
import ar.com.oxen.nibiru.mobile.gwt.ioc.DefaultGwtModule;
import ar.com.oxen.nibiru.mobile.gwt.ioc.DefaultSecurityModule;
import ar.com.oxen.nibiru.mobile.gwt.ioc.GwtInjector;
import ar.com.oxen.nibiru.mobile.kendoui.ioc.DefaultKendoUiModule;

import com.google.gwt.inject.client.GinModules;

@GinModules({ Module.class, DefaultGwtModule.class,
		DefaultGwtHardwareModule.class, DefaultKendoUiModule.class,
		DefaultSecurityModule.class })
public interface Injector extends GwtInjector {
}
