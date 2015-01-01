package ar.com.oxen.nibiru.mobile.mgwt.ui.security;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.security.SecurityMessages;
import ar.com.oxen.nibiru.mobile.core.impl.ui.security.LoginPresenter;
import ar.com.oxen.nibiru.mobile.mgwt.ui.mvp.BaseFormView;
import ar.com.oxen.nibiru.mobile.mgwt.ui.mvp.HasTapHandlersAdapter;

import com.google.gwt.user.client.ui.Label;
import com.googlecode.mgwt.ui.client.widget.button.Button;
import com.googlecode.mgwt.ui.client.widget.input.MPasswordTextBox;
import com.googlecode.mgwt.ui.client.widget.input.MTextBox;


public class LoginDisplay extends BaseFormView implements LoginPresenter.Display {
	private final MTextBox userTextBox;
	private final MPasswordTextBox passwordTextBox;
	private final Button loginButton;
	private final Label errorLabel;
	private final String loginError;

	@Inject
	public LoginDisplay(SecurityMessages messages) {
		checkNotNull(messages);

		Label lblUsuario = new Label(messages.user() + ":");
		getFormPanel().add(lblUsuario);

		userTextBox = new MTextBox();
		getFormPanel().add(userTextBox);

		Label lblClave = new Label(messages.password() + ":");
		getFormPanel().add(lblClave);

		passwordTextBox = new MPasswordTextBox();
		getFormPanel().add(passwordTextBox);

		loginButton = new Button(messages.login());
		getFormPanel().add(loginButton);

		errorLabel = new Label("");
		getFormPanel().add(errorLabel);

		loginError = messages.loginError();
	}

	@Override
	public String getUsername() {
		return userTextBox.getValue();
	}

	@Override
	public String getPassword() {
		return passwordTextBox.getValue();
	}

	@Override
	public HasClickHandler getLogin() {
		return new HasTapHandlersAdapter(loginButton);
	}

	@Override
	public void showLoginError() {
		errorLabel.setText(loginError);
	}
}
