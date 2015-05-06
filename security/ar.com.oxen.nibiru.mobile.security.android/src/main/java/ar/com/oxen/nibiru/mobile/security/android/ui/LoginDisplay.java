package ar.com.oxen.nibiru.mobile.security.android.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import android.content.Context;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import ar.com.oxen.nibiru.mobile.android.ui.mvp.BaseAndroidView;
import ar.com.oxen.nibiru.mobile.android.ui.mvp.ViewAdapter;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.security.core.api.ui.SecurityMessages;
import ar.com.oxen.nibiru.mobile.security.core.impl.ui.LoginPresenter.Display;

public class LoginDisplay extends BaseAndroidView<LinearLayout> implements Display {
	private final EditText username;
	private final EditText password;
	private final Button login;
	private final TextView error;
	private final String loginError;

	@Inject
	public LoginDisplay(Context context, SecurityMessages messages) {
		super(new LinearLayout(context));
		checkNotNull(context);
		checkNotNull(messages);
		asNative().setOrientation(LinearLayout.VERTICAL);

		TextView userLabel = new TextView(context);
		userLabel.setText(messages.user() + ":");
		asNative().addView(userLabel);

		username = new EditText(context);
		asNative().addView(username);

		TextView passwordLabel = new TextView(context);
		passwordLabel.setText(messages.password() + ":");
		asNative().addView(passwordLabel);

		password = new EditText(context);
		password
				.setTransformationMethod(new PasswordTransformationMethod());
		asNative().addView(password);

		login = new Button(context);
		login.setText(messages.login());
		asNative().addView(login);

		error = new TextView(context);
		asNative().addView(error);

		loginError = messages.loginError();
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
		error.setText(loginError);
	}
}
