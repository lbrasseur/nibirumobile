package ar.com.oxen.nibiru.mobile.gwt.ioc;

import ar.com.oxen.nibiru.mobile.core.api.app.Bootstrap;

import com.google.gwt.inject.client.Ginjector;

public interface GwtInjector extends Ginjector {
	Bootstrap getBootstrap();
}
