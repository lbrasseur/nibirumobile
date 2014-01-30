package ar.com.oxen.nibiru.mobile.smartgwt.ui.security;

import static com.google.common.base.Preconditions.checkNotNull;

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
	private final TextItem user;
	private final PasswordItem password;
	private final Button loginButton;
	private final Label errorLabel;
	private final String loginError;

	@Inject
	public LoginDisplay(SecurityMessages messages) {
		super(checkNotNull(messages).login());

		user = new TextItem("user", messages.user());
		password = new PasswordItem("password", messages.password());
		getForm().setFields(user, password);

		loginButton = new Button(messages.login());
		asNative().addMember(loginButton);

		errorLabel = new Label("");
		asNative().addMember(errorLabel);

		loginError = messages.loginError();
	}

	@Override
	public String getUsername() {
		return user.getValue();
	}

	@Override
	public String getPassword() {
		return password.getValue();
	}

	@Override
	public HasClickHandler getLogin() {
		return new HasClickHandlersAdapter(loginButton);
	}

	@Override
	public void showLoginError() {
		errorLabel.setText(loginError);
	}
}
