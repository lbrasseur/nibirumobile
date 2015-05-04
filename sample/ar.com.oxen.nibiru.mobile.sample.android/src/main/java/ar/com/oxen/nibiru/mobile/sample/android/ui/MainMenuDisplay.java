package ar.com.oxen.nibiru.mobile.sample.android.ui;

import javax.inject.Inject;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import ar.com.oxen.nibiru.mobile.android.ui.mvp.BaseAndroidView;
import ar.com.oxen.nibiru.mobile.android.ui.mvp.ViewAdapter;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.sample.android.R;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.MainMenuPresenter.Display;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SampleMessages;

public class MainMenuDisplay extends BaseAndroidView<View> implements Display {
	private final Button customerManagement;
	private final Button samples;
	
	@Inject
	public MainMenuDisplay(LayoutInflater layoutInflater, SampleMessages messages) {
		super(layoutInflater.inflate(R.layout.main_menu, null));
		findViewById(R.id.title, TextView.class).setText(messages.title());
		customerManagement = findViewById(R.id.userManagement);
		samples = findViewById(R.id.samples);
		customerManagement.setText(messages.customerManagement());
		samples.setText(messages.samples());
	}

	@Override
	public HasClickHandler getCustomerManagement() {
		return new ViewAdapter(customerManagement);
	}

	@Override
	public HasClickHandler getSamples() {
		return new ViewAdapter(samples);
	}
}
