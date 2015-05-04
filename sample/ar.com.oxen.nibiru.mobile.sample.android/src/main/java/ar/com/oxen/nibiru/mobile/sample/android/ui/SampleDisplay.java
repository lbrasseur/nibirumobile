package ar.com.oxen.nibiru.mobile.sample.android.ui;

import static com.google.common.base.Preconditions.checkNotNull;

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
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.TakesValue;
import ar.com.oxen.nibiru.mobile.sample.android.R;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SampleMessages;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SamplePresenter.Display;

public class SampleDisplay extends BaseAndroidView<View> implements Display {
	private final Button alertTrigger;
	private final EditText nameLoad;
	private final Button greetingTrigger;
	private final TextView greetingDisplay;
	private final Button navigateTrigger;
	private final Button showLocation;

	@Inject
	public SampleDisplay(LayoutInflater layoutInflater, SampleMessages messages) {
		super(layoutInflater.inflate(R.layout.sample, null));
		checkNotNull(messages);

		findViewById(R.id.title, TextView.class).setText(messages.title());

		alertTrigger = findViewById(R.id.alertTrigger);
		alertTrigger.setText(messages.showAlert());

		nameLoad = findViewById(R.id.nameLoad);

		greetingTrigger = findViewById(R.id.greetingTrigger);
		greetingTrigger.setText(messages.greet());

		greetingDisplay = findViewById(R.id.greetingDisplay);

		showLocation = findViewById(R.id.showLocation);
		showLocation.setText(messages.getPosition());

		navigateTrigger = findViewById(R.id.navigateTrigger);
		navigateTrigger.setText(messages.navigate());
	}

	@Override
	public HasClickHandler getAlertTrigger() {
		return new ViewAdapter(alertTrigger);
	}

	@Override
	public HasClickHandler getGreetingTrigger() {
		return new ViewAdapter(greetingTrigger);
	}

	@Override
	public TakesValue<String> getNameLoad() {
		return new TextViewAdapter(nameLoad);
	}

	@Override
	public TakesValue<String> getGreetingDisplay() {
		return new TextViewAdapter(greetingDisplay);
	}

	@Override
	public HasClickHandler getNavigateTrigger() {
		return new ViewAdapter(navigateTrigger);
	}

	@Override
	public HasClickHandler getShowLocation() {
		return new ViewAdapter(showLocation);
	}
}
