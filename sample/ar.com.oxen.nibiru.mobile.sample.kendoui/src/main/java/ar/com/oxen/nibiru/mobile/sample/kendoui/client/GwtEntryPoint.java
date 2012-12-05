package ar.com.oxen.nibiru.mobile.sample.kendoui.client;

import ar.com.oxen.nibiru.mobile.gwt.ioc.GwtInjector;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class GwtEntryPoint implements EntryPoint {
	private final GwtInjector injector = GWT.create(Injector.class);

	@Override
	public void onModuleLoad() {
		this.injector.getBootstrap().onBootstrap();
	}
}
