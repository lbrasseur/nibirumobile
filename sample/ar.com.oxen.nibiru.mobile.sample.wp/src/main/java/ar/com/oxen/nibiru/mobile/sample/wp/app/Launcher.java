package ar.com.oxen.nibiru.mobile.sample.wp.app;

import org.timepedia.exporter.client.Export;
import org.timepedia.exporter.client.Exportable;

import com.google.gwt.core.client.GWT;

@Export
public class Launcher  implements Exportable  {
	private final Injector injector = GWT.create(Injector.class);

	public void launch() {
		injector.getBootstrap().onBootstrap();
	}
}
