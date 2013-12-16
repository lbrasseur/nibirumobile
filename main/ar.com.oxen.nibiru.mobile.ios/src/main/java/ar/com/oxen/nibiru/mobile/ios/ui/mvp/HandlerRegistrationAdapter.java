package ar.com.oxen.nibiru.mobile.ios.ui.mvp;

import org.robovm.cocoatouch.uikit.UIControl;
import org.robovm.cocoatouch.uikit.UIControl.Listener;

import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;

public class HandlerRegistrationAdapter implements HandlerRegistration {
	private final UIControl control;
	private final Listener listener;

	public HandlerRegistrationAdapter(UIControl control, Listener listener) {
		this.control = control;
		this.listener = listener;
	}

	@Override
	public void removeHandler() {
		control.removeListener(listener);
	}
}
