package ar.com.oxen.nibiru.mobile.sample.ios.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import org.robovm.apple.foundation.NSBundle;
import org.robovm.apple.uikit.UIButton;
import org.robovm.apple.uikit.UIControlState;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UINibLoadingOptions;
import org.robovm.apple.uikit.UITextField;
import org.robovm.apple.uikit.UIView;
import org.robovm.objc.annotation.Property;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasValue;
import ar.com.oxen.nibiru.mobile.ios.ui.DefaultUITextFieldDelegate;
import ar.com.oxen.nibiru.mobile.ios.ui.mvp.BaseUIViewView;
import ar.com.oxen.nibiru.mobile.ios.ui.mvp.UIButtonAdapter;
import ar.com.oxen.nibiru.mobile.ios.ui.mvp.UITextFieldAdapter;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.CustomerFormPresenter.Display;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SampleMessages;

public class CustomerFormDisplay extends BaseUIViewView implements Display {

	private final SampleMessages messages;
	private UIView container;
	private UITextField firstName;
	private UITextField lastName;
	private UIButton save;
	private UIButton cancel;

	@Inject
	public CustomerFormDisplay(SampleMessages messages) {
		this.messages = checkNotNull(messages);
		NSBundle.getMainBundle().loadNib("customerForm", this,
				new UINibLoadingOptions());
	}

	@Property
	public void setContainer(UIView container) {
		this.container = checkNotNull(container);
	}

	@Property
	public void setFirstNameLabel(UILabel firstNameLabel) {
		checkNotNull(firstNameLabel);
		firstNameLabel.setText(messages.firstName());
	}

	@Property
	public void setFirstName(UITextField firstName) {
		this.firstName = checkNotNull(firstName);
		firstName.setDelegate(new DefaultUITextFieldDelegate());
	}

	@Property
	public void setLastNameLabel(UILabel lastNameLabel) {
		checkNotNull(lastNameLabel);
		lastNameLabel.setText(messages.lastName());
	}

	@Property
	public void setLastName(UITextField lastName) {
		this.lastName = checkNotNull(lastName);
		lastName.setDelegate(new DefaultUITextFieldDelegate());
	}

	@Property
	public void setSave(UIButton save) {
		this.save = checkNotNull(save);
		save.setTitle(messages.save(), UIControlState.Normal);
	}

	@Property
	public void setCancel(UIButton cancel) {
		this.cancel = checkNotNull(cancel);
		cancel.setTitle(messages.cancel(), UIControlState.Normal);
	}

	@Override
	public UIView asNative() {
		return container;
	}

	@Override
	public HasValue<String> getFirstName() {
		return new UITextFieldAdapter(firstName);
	}

	@Override
	public HasValue<String> getLastName() {
		return new UITextFieldAdapter(lastName);
	}

	@Override
	public HasClickHandler getSave() {
		return new UIButtonAdapter(save);
	}

	@Override
	public HasClickHandler getCancel() {
		return new UIButtonAdapter(cancel);
	}
}
