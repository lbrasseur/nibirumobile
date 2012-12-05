package ar.com.oxen.nibiru.mobile.mgwt.ui.security;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.security.SecurityMessages;
import ar.com.oxen.nibiru.mobile.core.impl.ui.security.LoginPresenter;
import ar.com.oxen.nibiru.mobile.mgwt.ui.mvp.BaseFormView;
import ar.com.oxen.nibiru.mobile.mgwt.ui.mvp.HasTapHandlersAdapter;

import com.google.gwt.user.client.ui.Label;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.MPasswordTextBox;
import com.googlecode.mgwt.ui.client.widget.MTextBox;


public class LoginDisplay extends BaseFormView implements LoginPresenter.Display {
	private MTextBox userTextBox;
	private MPasswordTextBox passwordTextBox;
	private Button loginButton;
	private Label errorLabel;
	private String loginError;

	@Inject
	public LoginDisplay(SecurityMessages messages) {
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

		this.loginError = messages.loginError();
	}

	@Override
	public String getUsername() {
		return this.userTextBox.getValue();
	}

	@Override
	public String getPassword() {
		return this.passwordTextBox.getValue();
	}

	@Override
	public HasClickHandler getLogin() {
		return new HasTapHandlersAdapter(this.loginButton);
	}

	@Override
	public void showLoginError() {
		this.errorLabel.setText(this.loginError);
	}
}
