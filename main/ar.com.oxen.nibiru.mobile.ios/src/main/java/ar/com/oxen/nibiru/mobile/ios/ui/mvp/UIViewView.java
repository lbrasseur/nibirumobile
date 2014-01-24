package ar.com.oxen.nibiru.mobile.ios.ui.mvp;

import org.robovm.cocoatouch.uikit.UIView;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.View;

public interface UIViewView extends View {
	UIView asNative();
}
