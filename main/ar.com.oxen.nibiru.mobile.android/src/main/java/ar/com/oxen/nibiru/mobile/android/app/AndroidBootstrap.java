package ar.com.oxen.nibiru.mobile.android.app;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.app.Bootstrap;
import ar.com.oxen.nibiru.mobile.core.api.app.EntryPoint;

public class AndroidBootstrap implements Bootstrap {
	private EntryPoint entryPoint;

	@Inject
	public AndroidBootstrap(EntryPoint entryPoint) {
		super();
		this.entryPoint = entryPoint;
	}

	@Override
	public void onBootstrap() {
		this.entryPoint.onApplicationStart();
	}
}
