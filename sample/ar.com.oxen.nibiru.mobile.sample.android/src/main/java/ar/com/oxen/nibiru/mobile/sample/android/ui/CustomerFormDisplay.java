package ar.com.oxen.nibiru.mobile.sample.android.ui;

import javax.inject.Inject;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import ar.com.oxen.nibiru.mobile.android.ui.mvp.BaseAndroidView;
import ar.com.oxen.nibiru.mobile.android.ui.mvp.TextViewAdapter;
import ar.com.oxen.nibiru.mobile.android.ui.mvp.ViewAdapter;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasValue;
import ar.com.oxen.nibiru.mobile.sample.android.R;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.CustomerFormPresenter.Display;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SampleMessages;

public class CustomerFormDisplay extends BaseAndroidView<View> implements
		Display {
	private final EditText firstName;
	private final EditText lastName;
	private final Button save;
	private final Button cancel;
	
	@Inject
	public CustomerFormDisplay(LayoutInflater layoutInflater, SampleMessages messages) {
		super(layoutInflater.inflate(R.layout.customer_form, null));
		findViewById(R.id.firstNameTv, TextView.class).setText(messages.firstName());
		findViewById(R.id.lastNameTv, TextView.class).setText(messages.lastName());
		firstName = findViewById(R.id.firstName);
		lastName = findViewById(R.id.lastName);
		save = findViewById(R.id.save);
		save.setText(messages.save());
		cancel = findViewById(R.id.cancel);
		cancel.setText(messages.cancel());
	}

	@Override
	public HasValue<String> getFirstName() {
		return new TextViewAdapter(firstName);
	}

	@Override
	public HasValue<String> getLastName() {
		return new TextViewAdapter(lastName);
	}

	@Override
	public HasClickHandler getSave() {
		return new ViewAdapter(save);
	}

	@Override
	public HasClickHandler getCancel() {
		return new ViewAdapter(cancel);
	}
}
