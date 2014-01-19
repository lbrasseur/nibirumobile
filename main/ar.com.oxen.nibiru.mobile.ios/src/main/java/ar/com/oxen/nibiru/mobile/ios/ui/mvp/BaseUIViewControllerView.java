package ar.com.oxen.nibiru.mobile.ios.ui.mvp;

import org.robovm.cocoatouch.uikit.UIViewController;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.View;

public class BaseUIViewControllerView implements View {
	private final UIViewController controller;

	public BaseUIViewControllerView() {
		controller = new UIViewController();
	}

	protected UIViewController getController() {
		return controller;
	}

	@Override
	public UIViewController asNative() {
		return controller;
	}
}
