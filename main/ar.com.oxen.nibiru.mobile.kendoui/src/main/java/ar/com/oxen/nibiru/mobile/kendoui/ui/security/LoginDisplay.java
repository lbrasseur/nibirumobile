package ar.com.oxen.nibiru.mobile.kendoui.ui.security;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.security.SecurityMessages;
import ar.com.oxen.nibiru.mobile.core.impl.ui.security.LoginPresenter;
import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.HasClickHandlersAdapter;
import ar.com.oxen.nibiru.mobile.kendoui.ui.mvp.BaseFormView;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginDisplay extends BaseFormView implements
		LoginPresenter.Display {
	public interface LoginDisplayUiBinder extends
			UiBinder<Widget, LoginDisplay> {
	}

	@UiField
	Label title;

	@UiField
	TextBox user;

	@UiField
	Label userLabel;

	@UiField
	PasswordTextBox password;

	@UiField
	Label passwordLabel;

	@UiField
	Anchor login;

	@UiField
	Label errorLabel;

	private String loginError;

	@Inject
	public LoginDisplay(LoginDisplayUiBinder uiBinder, SecurityMessages messages) {
		super();
		initWidget(uiBinder.createAndBindUi(this));
		this.title.setText(messages.login());
		this.userLabel.setText(messages.user());
		this.passwordLabel.setText(messages.password());
		this.login.setText(messages.login());
		this.loginError = messages.loginError();
	}

	@Override
	public String getUsername() {
		return this.user.getText();
	}

	@Override
	public String getPassword() {
		return this.password.getText();
	}

	@Override
	public HasClickHandler getLogin() {
		return new HasClickHandlersAdapter(this.login);
	}

	@Override
	public void showLoginError() {
		this.errorLabel.setText(this.loginError);
	}
}
