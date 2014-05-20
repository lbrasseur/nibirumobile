package ar.com.oxen.nibiru.mobile.sample.ios;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import org.robovm.cocoatouch.coregraphics.CGRect;
import org.robovm.cocoatouch.uikit.UIButton;
import org.robovm.cocoatouch.uikit.UIButtonType;
import org.robovm.cocoatouch.uikit.UIColor;
import org.robovm.cocoatouch.uikit.UIControlState;
import org.robovm.cocoatouch.uikit.UIScreen;
import org.robovm.cocoatouch.uikit.UIView;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.ios.ui.mvp.BaseUIViewView;
import ar.com.oxen.nibiru.mobile.ios.ui.mvp.UIButtonAdapter;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SampleMessages;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SecondPresenter.Display;

public class SecondDisplay extends BaseUIViewView implements Display {
	private final UIView container;
	private final UIButton backTrigger;

	@Inject
	public SecondDisplay(SampleMessages messages) {
		checkNotNull(messages);
		container = new UIView(UIScreen.getMainScreen().getBounds());
		container.setBackgroundColor(UIColor.lightGrayColor());

		backTrigger = UIButton.fromType(UIButtonType.RoundedRect);
		backTrigger.setFrame(new CGRect(20, 230, 100, 25));
		backTrigger.setTitle(messages.back(), UIControlState.Normal);
		container.addSubview(backTrigger);
	}

	@Override
	public HasClickHandler getBackTrigger() {
		return new UIButtonAdapter(backTrigger);
	}

	@Override
	public UIView asNative() {
		return container;
	}
}
