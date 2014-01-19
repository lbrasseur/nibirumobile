package ar.com.oxen.nibiru.mobile.sample.android;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import android.content.Context;
import android.view.View;
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

public class SampleDisplay extends BaseAndroidView implements Display {
	private final LinearLayout view;
	private final Button alertTrigger;
	private final EditText nameLoad;
	private final Button greetingTrigger;
	private final TextView greetingDisplay;
	private final Button backTrigger;
	private final Button showLocation;

	@Inject
	public SampleDisplay(Context context, SampleMessages messages) {
		checkNotNull(context);
		checkNotNull(messages);
		view = new LinearLayout(context);
		view.setOrientation(LinearLayout.VERTICAL);

		TextView mensaje = new TextView(context);
		mensaje.setText(messages.title());
		view.addView(mensaje);

		alertTrigger = new Button(context);
		alertTrigger.setText(messages.showAlert());
		view.addView(alertTrigger);

		nameLoad = new EditText(context);
		nameLoad.setText("Pepe");
		view.addView(nameLoad);

		greetingTrigger = new Button(context);
		greetingTrigger.setText(messages.greet());
		view.addView(greetingTrigger);

		greetingDisplay = new TextView(context);
		greetingDisplay.setText("");
		view.addView(greetingDisplay);

		showLocation = new Button(context);
		showLocation.setText(messages.getPosition());
		view.addView(showLocation);

		backTrigger = new Button(context);
		backTrigger.setText(messages.back());
		view.addView(backTrigger);
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
	public HasClickHandler getBackTrigger() {
		return new ViewAdapter(backTrigger);
	}

	@Override
	public HasClickHandler getShowLocation() {
		return new ViewAdapter(showLocation);
	}

	@Override
	public View asNative() {
		return view;
	}
}
