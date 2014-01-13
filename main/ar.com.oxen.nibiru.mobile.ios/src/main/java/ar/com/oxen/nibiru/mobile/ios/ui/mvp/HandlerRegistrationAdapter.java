package ar.com.oxen.nibiru.mobile.ios.ui.mvp;

import static com.google.common.base.Preconditions.checkNotNull;

import org.robovm.cocoatouch.uikit.UIControl;
import org.robovm.cocoatouch.uikit.UIControl.Listener;

import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;

public class HandlerRegistrationAdapter implements HandlerRegistration {
	private final UIControl control;
	private final Listener listener;

	public HandlerRegistrationAdapter(UIControl control, Listener listener) {
		this.control = checkNotNull(control);
		this.listener = checkNotNull(listener);
	}

	@Override
	public void removeHandler() {
		control.removeListener(listener);
	}
}
