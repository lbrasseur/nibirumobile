package ar.com.oxen.nibiru.mobile.android.app;

import javax.inject.Inject;

import roboguice.activity.RoboActivity;
import android.os.Bundle;
import ar.com.oxen.nibiru.mobile.core.api.app.Bootstrap;

public class BootstrapActivity extends RoboActivity {
	@Inject
	private Bootstrap bootstrap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		bootstrap.onBootstrap();
		finish();
	}
}
