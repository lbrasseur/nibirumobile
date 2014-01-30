package ar.com.oxen.nibiru.mobile.smartgwt.ui;

import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;

import com.google.gwt.user.client.Window;

public class SmartGwtAlertService implements AlertManager {

	@Override
	public void showMessage(String message) {
		Window.alert(message);
	}

	@Override
	public void showException(Exception exception) {
		showMessage(exception.getClass() + ": " + exception.getMessage());
	}
}
