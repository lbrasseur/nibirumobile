package ar.com.oxen.nibiru.mobile.smartgwt.ui.security;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.security.SecurityMessages;
import ar.com.oxen.nibiru.mobile.core.impl.ui.security.LoginPresenter;
import ar.com.oxen.nibiru.mobile.smartgwt.ui.mvp.BaseFormView;
import ar.com.oxen.nibiru.mobile.smartgwt.ui.mvp.HasClickHandlersAdapter;

import com.google.gwt.user.client.ui.Label;
import com.smartgwt.mobile.client.widgets.Button;
import com.smartgwt.mobile.client.widgets.form.fields.PasswordItem;
import com.smartgwt.mobile.client.widgets.form.fields.TextItem;

public class LoginDisplay extends BaseFormView implements
		LoginPresenter.Display {
	private TextItem user;
	private PasswordItem password;
	private Button loginButton;
	private Label errorLabel;
	private String loginError;

	@Inject
	public LoginDisplay(SecurityMessages messages) {
		super(messages.login());

		this.user = new TextItem("user", messages.user());
		this.password = new PasswordItem("password", messages.password());
		this.getForm().setFields(this.user, this.password);

		this.loginButton = new Button(messages.login());
		this.asNative().addMember(loginButton);

		errorLabel = new Label("");
		this.asNative().addMember(errorLabel);

		this.loginError = messages.loginError();
	}

	@Override
	public String getUsername() {
		return this.user.getValue();
	}

	@Override
	public String getPassword() {
		return this.password.getValue();
	}

	@Override
	public HasClickHandler getLogin() {
		return new HasClickHandlersAdapter(this.loginButton);
	}

	@Override
	public void showLoginError() {
		this.errorLabel.setText(this.loginError);
	}
}
