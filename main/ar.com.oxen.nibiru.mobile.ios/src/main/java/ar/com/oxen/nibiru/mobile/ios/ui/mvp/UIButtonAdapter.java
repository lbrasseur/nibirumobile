package ar.com.oxen.nibiru.mobile.ios.ui.mvp;

import static com.google.common.base.Preconditions.checkNotNull;

import org.robovm.cocoatouch.uikit.UIButton;
import org.robovm.cocoatouch.uikit.UIControl.OnTouchUpInsideListener;

import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;

public class UIButtonAdapter implements HasClickHandler {
	private final UIButton button;

	public UIButtonAdapter(UIButton button) {
		this.button = checkNotNull(button);
	}

	@Override
	public HandlerRegistration setClickHandler(ClickHandler clickHandler) {
		OnTouchUpInsideListener listener = new ClickHandlerAdapter(clickHandler);
		button.addOnTouchUpInsideListener(listener);
		return new HandlerRegistrationAdapter(button, listener);
	}
}
