package ar.com.oxen.nibiru.mobile.mgwt.ui;

import static com.google.common.base.Preconditions.checkNotNull;
import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;

import com.google.gwt.user.client.Window;
import com.googlecode.mgwt.ui.client.widget.dialog.ConfirmDialog.ConfirmCallback;
import com.googlecode.mgwt.ui.client.widget.dialog.Dialogs;

public class MgwtAlertManager implements AlertManager {
	@Override
	public void showMessage(String message) {
		Dialogs.alert("", message, null);
	}

	@Override
	public void showException(Exception exception) {
		showMessage(exception.getClass() + ": " + exception.getMessage());
	}

	@Override
	public void prompt(String title, String message, Callback<String> callback) {
		checkNotNull(title);
		checkNotNull(message);
		checkNotNull(callback);
		callback.onSuccess(Window.prompt(title + "\n" + message, ""));
	}

	@Override
	public void confirm(String title, String message,
			final Callback<Boolean> callback) {
		checkNotNull(title);
		checkNotNull(message);
		checkNotNull(callback);
		Dialogs.confirm(title, message, new ConfirmCallback() {
			@Override
			public void onOk() {
				callback.onSuccess(true);
			}

			@Override
			public void onCancel() {
				callback.onSuccess(false);
			}
		});
	}
}
