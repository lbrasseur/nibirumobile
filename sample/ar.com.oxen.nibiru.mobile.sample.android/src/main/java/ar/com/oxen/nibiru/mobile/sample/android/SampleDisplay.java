package ar.com.oxen.nibiru.mobile.sample.android;

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
	private LinearLayout view;
	private Button alertTrigger;
	private EditText nameLoad;
	private Button greetingTrigger;
	private TextView greetingDisplay;
	private Button backTrigger;
	private Button showLocation;

	@Inject
	public SampleDisplay(Context context, SampleMessages messages) {
		super();
		this.view = new LinearLayout(context);
		this.view.setOrientation(LinearLayout.VERTICAL);

		TextView mensaje = new TextView(context);
		mensaje.setText(messages.title());
		this.view.addView(mensaje);

		this.alertTrigger = new Button(context);
		this.alertTrigger.setText(messages.showAlert());
		this.view.addView(this.alertTrigger);

		this.nameLoad = new EditText(context);
		this.nameLoad.setText("Pepe");
		this.view.addView(this.nameLoad);

		this.greetingTrigger = new Button(context);
		this.greetingTrigger.setText(messages.greet());
		this.view.addView(this.greetingTrigger);

		this.greetingDisplay = new TextView(context);
		this.greetingDisplay.setText("");
		this.view.addView(this.greetingDisplay);

		this.showLocation = new Button(context);
		this.showLocation.setText(messages.getPosition());
		this.view.addView(this.showLocation);

		this.backTrigger = new Button(context);
		this.backTrigger.setText(messages.back());
		this.view.addView(this.backTrigger);
	}

	@Override
	public HasClickHandler getAlertTrigger() {
		return new ViewAdapter(this.alertTrigger);
	}

	@Override
	public HasClickHandler getGreetingTrigger() {
		return new ViewAdapter(this.greetingTrigger);
	}

	@Override
	public TakesValue<String> getNameLoad() {
		return new TextViewAdapter(this.nameLoad);
	}

	@Override
	public TakesValue<String> getGreetingDisplay() {
		return new TextViewAdapter(this.greetingDisplay);
	}

	@Override
	public HasClickHandler getBackTrigger() {
		return new ViewAdapter(this.backTrigger);
	}

	@Override
	public HasClickHandler getShowLocation() {
		return new ViewAdapter(this.showLocation);
	}
	
	@Override
	public View asNative() {
		return view;
	}
}
