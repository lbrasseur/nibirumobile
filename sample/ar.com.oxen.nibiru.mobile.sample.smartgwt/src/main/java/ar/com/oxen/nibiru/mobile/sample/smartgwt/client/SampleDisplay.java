package ar.com.oxen.nibiru.mobile.sample.smartgwt.client;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.TakesValue;
import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.LabelAdapter;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SampleMessages;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SamplePresenter;
import ar.com.oxen.nibiru.mobile.smartgwt.ui.mvp.BaseFormView;
import ar.com.oxen.nibiru.mobile.smartgwt.ui.mvp.FormItemAdapter;
import ar.com.oxen.nibiru.mobile.smartgwt.ui.mvp.HasClickHandlersAdapter;

import com.google.gwt.user.client.ui.Label;
import com.smartgwt.mobile.client.widgets.Button;
import com.smartgwt.mobile.client.widgets.form.fields.TextItem;

public class SampleDisplay extends BaseFormView implements
		SamplePresenter.Display {
	private Button alertTrigger;
	private TextItem nameLoad;
	private Button greetingTrigger;
	private Label greetingDisplay;
	private Button backTrigger;
	private Button showLocation;

	@Inject
	public SampleDisplay(SampleMessages messages) {
		super(messages.title());
		this.nameLoad = new TextItem("nameLoad", messages.title());
		this.nameLoad.setValue("Pepe");
		
		this.getForm().setFields(nameLoad);

		this.alertTrigger = new Button(messages.showAlert());
		this.asNative().addMember(alertTrigger);

		this.greetingTrigger = new Button(messages.greet());
		this.asNative().addMember(greetingTrigger);

		this.greetingDisplay = new Label("");
		this.asNative().addMember(greetingDisplay);
		this.greetingDisplay.setSize("213px", "60px");

		this.showLocation = new Button(messages.getPosition());
		this.asNative().addMember(this.showLocation);

		this.backTrigger = new Button(messages.back());
		this.asNative().addMember(backTrigger);
	}

	@Override
	public HasClickHandler getAlertTrigger() {
		return new HasClickHandlersAdapter(this.alertTrigger);
	}

	@Override
	public HasClickHandler getGreetingTrigger() {
		return new HasClickHandlersAdapter(this.greetingTrigger);
	}

	@Override
	public TakesValue<String> getNameLoad() {
		return new FormItemAdapter<String>(this.nameLoad);
	}

	@Override
	public TakesValue<String> getGreetingDisplay() {
		return new LabelAdapter(this.greetingDisplay);
	}

	@Override
	public HasClickHandler getBackTrigger() {
		return new HasClickHandlersAdapter(this.backTrigger);
	}

	@Override
	public HasClickHandler getShowLocation() {
		return new HasClickHandlersAdapter(this.showLocation);
	}
}
