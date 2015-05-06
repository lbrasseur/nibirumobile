package ar.com.oxen.nibiru.mobile.sample.ios.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import org.robovm.apple.foundation.NSBundle;
import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UIControlState;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UINibLoadingOptions;
import org.robovm.apple.uikit.UIView;
import org.robovm.objc.annotation.Property;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.ios.ui.mvp.BaseUIViewView;
import ar.com.oxen.nibiru.mobile.ios.ui.mvp.UIButtonAdapter;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.MainMenuPresenter.Display;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SampleMessages;

public class MainMenuDisplay extends BaseUIViewView implements Display {
	private final SampleMessages messages;
	private UIView container;
	private UIButton customerManagement;
	private UIButton samples;

	@Inject
	public MainMenuDisplay(SampleMessages messages) {
		this.messages = checkNotNull(messages);
		NSBundle.getMainBundle().loadNib("mainMenu", this,
				new UINibLoadingOptions());
	}

	@Property
	public void setContainer(UIView container) {
		this.container = checkNotNull(container);
	}

	@Property
	public void setTitle(UILabel title) {
		checkNotNull(title).setText(messages.title());
	}

	@Property
	public void setCustomerManagement(UIButton customerManagement) {
		this.customerManagement = checkNotNull(customerManagement);
		customerManagement.setTitle(messages.customerManagement(),
				UIControlState.Normal);
	}

	@Property
	public void setSamples(UIButton samples) {
		this.samples = checkNotNull(samples);
		samples.setTitle(messages.samples(), UIControlState.Normal);
	}

	@Override
	public UIView asNative() {
		return container;
	}

	@Override
	public HasClickHandler getCustomerManagement() {
		return new UIButtonAdapter(customerManagement);
	}

	@Override
	public HasClickHandler getSamples() {
		return new UIButtonAdapter(samples);
	}
}
