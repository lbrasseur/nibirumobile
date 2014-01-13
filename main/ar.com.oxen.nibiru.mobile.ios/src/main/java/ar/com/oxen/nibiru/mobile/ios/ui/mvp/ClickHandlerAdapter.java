package ar.com.oxen.nibiru.mobile.ios.ui.mvp;

import org.robovm.cocoatouch.uikit.UIControl;
import org.robovm.cocoatouch.uikit.UIControl.OnTouchUpInsideListener;
import org.robovm.cocoatouch.uikit.UIEvent;

import static com.google.common.base.Preconditions.checkNotNull;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ClickHandler;

public class ClickHandlerAdapter implements OnTouchUpInsideListener {
	private final ClickHandler clickHandler;

	public ClickHandlerAdapter(ClickHandler clickHandler) {
		this.clickHandler = checkNotNull(clickHandler);
	}

	@Override
	public void onTouchUpInside(UIControl control, UIEvent event) {
		clickHandler.onClick();
	}
}
