package ar.com.oxen.nibiru.mobile.sample.android;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import ar.com.oxen.nibiru.mobile.android.ui.mvp.BaseAndroidView;
import ar.com.oxen.nibiru.mobile.android.ui.mvp.TextViewAdapter;
import ar.com.oxen.nibiru.mobile.android.ui.mvp.ViewAdapter;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.TakesValue;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SampleMessages;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SamplePresenter.Display;

public class SampleDisplay extends BaseAndroidView<LinearLayout> implements Display {
	private final Button alertTrigger;
	private final EditText nameLoad;
	private final Button greetingTrigger;
	private final TextView greetingDisplay;
	private final Button navigateTrigger;
	private final Button showLocation;

	@Inject
	public SampleDisplay(Context context, SampleMessages messages) {
		super(new LinearLayout(context));
		checkNotNull(context);
		checkNotNull(messages);
		asNative().setOrientation(LinearLayout.VERTICAL);

		TextView mensaje = new TextView(context);
		mensaje.setText(messages.title());
		asNative().addView(mensaje);

		alertTrigger = new Button(context);
		alertTrigger.setText(messages.showAlert());
		asNative().addView(alertTrigger);

		nameLoad = new EditText(context);
		nameLoad.setText("Pepe");
		asNative().addView(nameLoad);

		greetingTrigger = new Button(context);
		greetingTrigger.setText(messages.greet());
		asNative().addView(greetingTrigger);

		greetingDisplay = new TextView(context);
		greetingDisplay.setText("");
		asNative().addView(greetingDisplay);

		showLocation = new Button(context);
		showLocation.setText(messages.getPosition());
		asNative().addView(showLocation);

		navigateTrigger = new Button(context);
		navigateTrigger.setText(messages.navigate());
		asNative().addView(navigateTrigger);
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
