package ar.com.oxen.nibiru.mobile.wp.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.gwt.user.client.Window;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;

public class WindowsPhoneAlertManager implements AlertManager {
	@Override
	public void showMessage(String message) {
		checkNotNull(message);
		alert(message);
	}

	@Override
	public void showException(Exception exception) {
		checkNotNull(exception);
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
	public void confirm(String title, String message, Callback<Boolean> callback) {
		checkNotNull(title);
		checkNotNull(message);
		checkNotNull(callback);
		callback.onSuccess(Window.confirm(title + "\n" + message));
	}

	private static native void alert(String message) /*-{
	  new Windows.UI.Popups.MessageDialog(message).showAsync();
	}-*/;
}
