package ar.com.oxen.nibiru.mobile.sample.mgwt.client;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.TakesValue;
import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.LabelAdapter;
import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.TakesValueAdapter;
import ar.com.oxen.nibiru.mobile.mgwt.ui.mvp.BaseFormView;
import ar.com.oxen.nibiru.mobile.mgwt.ui.mvp.HasTapHandlersAdapter;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SampleMessages;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SamplePresenter;

import com.google.gwt.user.client.ui.Label;
import com.googlecode.mgwt.ui.client.widget.Button;
import com.googlecode.mgwt.ui.client.widget.MTextBox;

public class SampleDisplay extends BaseFormView implements
		SamplePresenter.Display {
	private Button alertTrigger;
	private MTextBox nameLoad;
	private Button greetingTrigger;
	private Label greetingDisplay;
	private Button backTrigger;
	private Button showLocation;

	@Inject
	public SampleDisplay(SampleMessages messages) {
		Label lblEjemploDeVista = new Label(messages.title());
		getFormPanel().add(lblEjemploDeVista);

		alertTrigger = new Button(messages.showAlert());
		getFormPanel().add(alertTrigger);
		alertTrigger.setSize("130px", "26px");

		nameLoad = new MTextBox();
		nameLoad.setText("Pepe");
		getFormPanel().add(nameLoad);

		greetingTrigger = new Button(messages.greet());
		getFormPanel().add(greetingTrigger);
		greetingTrigger.setSize("78px", "19px");

		greetingDisplay = new Label("");
		getFormPanel().add(greetingDisplay);
		greetingDisplay.setSize("213px", "60px");

		showLocation = new Button(messages.getPosition());
		getFormPanel().add(showLocation);
		showLocation.setSize("130px", "19px");

		backTrigger = new Button(messages.back());
		getFormPanel().add(backTrigger);
		backTrigger.setSize("78px", "19px");
	}

	@Override
	public HasClickHandler getAlertTrigger() {
		return new HasTapHandlersAdapter(this.alertTrigger);
	}

	@Override
	public HasClickHandler getGreetingTrigger() {
		return new HasTapHandlersAdapter(this.greetingTrigger);
	}

	@Override
	public TakesValue<String> getNameLoad() {
		return new TakesValueAdapter<String>(this.nameLoad);
	}

	@Override
	public TakesValue<String> getGreetingDisplay() {
		return new LabelAdapter(this.greetingDisplay);
	}

	@Override
	public HasClickHandler getBackTrigger() {
		return new HasTapHandlersAdapter(this.backTrigger);
	}

	@Override
	public HasClickHandler getShowLocation() {
		return new HasTapHandlersAdapter(this.showLocation);
	}
}
