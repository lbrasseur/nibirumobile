package ar.com.oxen.nibiru.mobile.sample.mgwt.client;

import static com.google.common.base.Preconditions.checkNotNull;

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
	private final Button alertTrigger;
	private final MTextBox nameLoad;
	private final Button greetingTrigger;
	private final Label greetingDisplay;
	private final Button backTrigger;
	private final Button showLocation;

	@Inject
	public SampleDisplay(SampleMessages messages) {
		checkNotNull(messages);

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
		return new HasTapHandlersAdapter(alertTrigger);
	}

	@Override
	public HasClickHandler getGreetingTrigger() {
		return new HasTapHandlersAdapter(greetingTrigger);
	}

	@Override
	public TakesValue<String> getNameLoad() {
		return new TakesValueAdapter<String>(nameLoad);
	}

	@Override
	public TakesValue<String> getGreetingDisplay() {
		return new LabelAdapter(greetingDisplay);
	}

	@Override
	public HasClickHandler getBackTrigger() {
		return new HasTapHandlersAdapter(backTrigger);
	}

	@Override
	public HasClickHandler getShowLocation() {
		return new HasTapHandlersAdapter(showLocation);
	}
}
