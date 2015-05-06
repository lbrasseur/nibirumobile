package ar.com.oxen.nibiru.mobile.sample.ios.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import org.robovm.apple.coregraphics.CGRect;
import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UIButtonType;
import org.robovm.apple.uikit.UIColor;
import org.robovm.apple.uikit.UIControlState;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UIScreen;
import org.robovm.apple.uikit.UITextBorderStyle;
import org.robovm.apple.uikit.UITextField;
import org.robovm.apple.uikit.UIView;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.TakesValue;
import ar.com.oxen.nibiru.mobile.ios.ui.mvp.BaseUIViewView;
import ar.com.oxen.nibiru.mobile.ios.ui.mvp.UIButtonAdapter;
import ar.com.oxen.nibiru.mobile.ios.ui.mvp.UILabelAdapter;
import ar.com.oxen.nibiru.mobile.ios.ui.mvp.UITextFieldAdapter;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SampleMessages;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SamplePresenter.Display;

public class SampleDisplay extends BaseUIViewView implements Display {
	private final UIView container;
	private final UIButton alertTrigger;
	private final UITextField nameLoad;
	private final UIButton greetingTrigger;
	private final UILabel greetingDisplay;
	private final UIButton navigateTrigger;
	private final UIButton showLocation;

	@Inject
	public SampleDisplay(SampleMessages messages) {
		checkNotNull(messages);
		container = new UIView(UIScreen.getMainScreen().getBounds());
		container.setBackgroundColor(UIColor.lightGray());

		UILabel mensaje = new UILabel(new CGRect(20, 100, 200, 25));
		mensaje.setText(messages.title());
		mensaje.setBackgroundColor(UIColor.clear());
		container.addSubview(mensaje);

		alertTrigger = UIButton.create(UIButtonType.RoundedRect);
		alertTrigger.setFrame(new CGRect(20, 130, 100, 25));
		alertTrigger.setTitle(messages.showAlert(), UIControlState.Normal);
		container.addSubview(alertTrigger);

		nameLoad = new UITextField(new CGRect(20, 210, 200, 25));
		nameLoad.setText("Pepe");
		nameLoad.setBorderStyle(UITextBorderStyle.RoundedRect);
		nameLoad.setDelegate(getTextFieldDelegate());
		container.addSubview(nameLoad);

		greetingTrigger = UIButton.create(UIButtonType.RoundedRect);
		greetingTrigger.setFrame(new CGRect(20, 240, 100, 25));
		greetingTrigger.setTitle(messages.greet(), UIControlState.Normal);
		container.addSubview(greetingTrigger);

		greetingDisplay = new UILabel(new CGRect(20, 270, 200, 25));
		greetingDisplay.setText("");
		greetingDisplay.setBackgroundColor(UIColor.clear());
		container.addSubview(greetingDisplay);

		showLocation = UIButton.create(UIButtonType.RoundedRect);
		showLocation.setFrame(new CGRect(20, 300, 100, 25));
		showLocation.setTitle(messages.getPosition(), UIControlState.Normal);
		container.addSubview(showLocation);

		navigateTrigger = UIButton.create(UIButtonType.RoundedRect);
		navigateTrigger.setFrame(new CGRect(20, 330, 100, 25));
		navigateTrigger.setTitle(messages.navigate(), UIControlState.Normal);
		container.addSubview(navigateTrigger);
	}

	@Override
	public HasClickHandler getAlertTrigger() {
		return new UIButtonAdapter(alertTrigger);
	}

	@Override
	public HasClickHandler getGreetingTrigger() {
		return new UIButtonAdapter(greetingTrigger);
	}

	@Override
	public TakesValue<String> getNameLoad() {
		return new UITextFieldAdapter(nameLoad);
	}

	@Override
	public TakesValue<String> getGreetingDisplay() {
		return new UILabelAdapter(greetingDisplay);
	}

	@Override
	public HasClickHandler getNavigateTrigger() {
		return new UIButtonAdapter(navigateTrigger);
	}

	@Override
	public HasClickHandler getShowLocation() {
		return new UIButtonAdapter(showLocation);
	}

	@Override
	public UIView asNative() {
		return container;
	}
}
