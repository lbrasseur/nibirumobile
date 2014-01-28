package ar.com.oxen.nibiru.mobile.gwt.ui;

import static com.google.common.base.Preconditions.checkNotNull;
import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;

import com.google.gwt.user.client.Window;

public class GwtAlertManager implements AlertManager {
	@Override
	public void showMessage(String message) {
		checkNotNull(message);
		Window.alert(message);
	}

	@Override
	public void showException(Exception exception) {
		checkNotNull(exception);
		showMessage(exception.getClass() + ": " + exception.getMessage());
	}
}
