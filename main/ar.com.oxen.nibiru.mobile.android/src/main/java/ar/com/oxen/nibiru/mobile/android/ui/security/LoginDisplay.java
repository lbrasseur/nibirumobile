package ar.com.oxen.nibiru.mobile.android.ui.security;

import javax.inject.Inject;

import android.content.Context;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import ar.com.oxen.nibiru.mobile.android.ui.mvp.BaseAndroidView;
import ar.com.oxen.nibiru.mobile.android.ui.mvp.ViewAdapter;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.security.SecurityMessages;
import ar.com.oxen.nibiru.mobile.core.impl.ui.security.LoginPresenter.Display;

public class LoginDisplay extends BaseAndroidView implements Display {
	private final EditText username;
	private final EditText password;
	private final Button login;
	private final TextView error;
	private final String loginError;
	private final LinearLayout view;

	@Inject
	public LoginDisplay(Context context, SecurityMessages messages) {
		view = new LinearLayout(context);
		view.setOrientation(LinearLayout.VERTICAL);

		TextView userLabel = new TextView(context);
		userLabel.setText(messages.user() + ":");
		view.addView(userLabel);

		username = new EditText(context);
		view.addView(username);

		TextView passwordLabel = new TextView(context);
		passwordLabel.setText(messages.password() + ":");
		view.addView(passwordLabel);

		password = new EditText(context);
		password
				.setTransformationMethod(new PasswordTransformationMethod());
		view.addView(this.password);

		login = new Button(context);
		login.setText(messages.login());
		view.addView(this.login);

		this.error = new TextView(context);
		view.addView(error);

		this.loginError = messages.loginError();
	}

	@Override
	public String getUsername() {
		return username.getText().toString();
	}

	@Override
	public String getPassword() {
		return password.getText().toString();
	}

	@Override
	public HasClickHandler getLogin() {
		return new ViewAdapter(login);
	}

	@Override
	public void showLoginError() {
		this.error.setText(loginError);
	}

	@Override
	public View asNative() {
		return view;
	}
}
