package ar.com.oxen.nibiru.mobile.ios.ui.security;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import org.robovm.cocoatouch.coregraphics.CGRect;
import org.robovm.cocoatouch.uikit.UIButton;
import org.robovm.cocoatouch.uikit.UIButtonType;
import org.robovm.cocoatouch.uikit.UIColor;
import org.robovm.cocoatouch.uikit.UIControlState;
import org.robovm.cocoatouch.uikit.UILabel;
import org.robovm.cocoatouch.uikit.UIScreen;
import org.robovm.cocoatouch.uikit.UITextBorderStyle;
import org.robovm.cocoatouch.uikit.UITextField;
import org.robovm.cocoatouch.uikit.UIView;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.security.SecurityMessages;
import ar.com.oxen.nibiru.mobile.core.impl.ui.security.LoginPresenter.Display;
import ar.com.oxen.nibiru.mobile.ios.ui.mvp.BaseUIViewView;
import ar.com.oxen.nibiru.mobile.ios.ui.mvp.UIButtonAdapter;

public class LoginDisplay extends BaseUIViewView implements Display {
	private final UIView container;
	private final UITextField username;
	private final UITextField password;
	private final UILabel errorLabel;
	private final UIButton loginButton;

	@Inject
	public LoginDisplay(SecurityMessages messages) {
		checkNotNull(messages);
		container = new UIView(UIScreen.getMainScreen().getBounds());

		UILabel usernameLabel = new UILabel(new CGRect(20, 50, 100, 25));
		usernameLabel.setText(messages.user() + ":");
		usernameLabel.setBackgroundColor(UIColor.clearColor());
		container.addSubview(usernameLabel);

		username = new UITextField(new CGRect(120, 50, 150, 25));
		username.setBorderStyle(UITextBorderStyle.RoundedRect);
		username.setDelegate(getTextFieldDelegate());
		container.addSubview(username);

		UILabel passwordLabel = new UILabel(new CGRect(20, 100, 100, 25));
		passwordLabel.setText(messages.password() + ":");
		passwordLabel.setBackgroundColor(UIColor.clearColor());
		container.addSubview(passwordLabel);

		password = new UITextField(new CGRect(120, 100, 150, 25));
		password.setBorderStyle(UITextBorderStyle.RoundedRect);
		password.setSecureTextEntry(true);
		password.setDelegate(getTextFieldDelegate());
		container.addSubview(password);

		errorLabel = new UILabel(new CGRect(20, 150, 200, 25));
		errorLabel.setBackgroundColor(UIColor.clearColor());
		container.addSubview(errorLabel);

		loginButton = UIButton.fromType(UIButtonType.RoundedRect);
		loginButton.setFrame(new CGRect(80, 200, 100, 30));
		loginButton.setTitle("Login", UIControlState.Normal);
		container.addSubview(loginButton);
	}

	@Override
	public String getUsername() {
		return username.getText();
	}

	@Override
	public String getPassword() {
		return password.getText();
	}

	@Override
	public HasClickHandler getLogin() {
		return new UIButtonAdapter(loginButton);
	}

	@Override
	public void showLoginError() {
		errorLabel.setText("Invalid credentials");
	}

	@Override
	public UIView asNative() {
		return container;
	}
}
