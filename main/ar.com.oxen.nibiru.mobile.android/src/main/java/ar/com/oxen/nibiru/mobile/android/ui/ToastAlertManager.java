package ar.com.oxen.nibiru.mobile.android.ui;

import javax.inject.Inject;

import android.content.Context;
import android.widget.Toast;
import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;

public class ToastAlertManager implements AlertManager {
	private Context context;

	@Inject
	public ToastAlertManager(Context context) {
		this.context = context;
	}

	@Override
	public void showMessage(String message) {
		Toast.makeText(this.context, message, Toast.LENGTH_LONG).show();
	}

	@Override
	public void showException(Exception exception) {
		this.showMessage(exception.getClass() + ": " + exception.getMessage());
	}
}
