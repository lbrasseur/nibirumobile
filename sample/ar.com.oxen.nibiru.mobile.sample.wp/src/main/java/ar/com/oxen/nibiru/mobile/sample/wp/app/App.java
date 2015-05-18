package ar.com.oxen.nibiru.mobile.sample.wp.app;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.Exportable;

import com.google.gwt.core.client.GWT;

@Export
public class App implements Exportable {
	private static final Injector injector = GWT.create(Injector.class);

	private App() {
	}

	public static void launch() {
		injector.getBootstrap().onBootstrap();
	}
}
