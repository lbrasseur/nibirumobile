package ar.com.oxen.nibiru.mobile.android.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import android.content.Context;
import android.widget.Toast;
import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;

public class ToastAlertManager implements AlertManager {
	private final Context context;

	@Inject
	public ToastAlertManager(Context context) {
		this.context = checkNotNull(context);
	}

	@Override
	public void showMessage(String message) {
		checkNotNull(message);
		Toast.makeText(context, message, Toast.LENGTH_LONG).show();
	}

	@Override
	public void showException(Exception exception) {
		checkNotNull(exception);
		showMessage(exception.getClass() + ": " + exception.getMessage());
	}
}
