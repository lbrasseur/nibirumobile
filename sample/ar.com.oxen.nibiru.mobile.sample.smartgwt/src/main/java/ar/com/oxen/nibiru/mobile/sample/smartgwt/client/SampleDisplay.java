package ar.com.oxen.nibiru.mobile.sample.smartgwt.client;

import static com.google.common.base.Preconditions.checkNotNull;

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
	private final Button alertTrigger;
	private final TextItem nameLoad;
	private final Button greetingTrigger;
	private final Label greetingDisplay;
	private final Button backTrigger;
	private final Button showLocation;

	@Inject
	public SampleDisplay(SampleMessages messages) {
		super(checkNotNull(messages).title());

		nameLoad = new TextItem("nameLoad", messages.title());
		nameLoad.setValue("Pepe");
		
		getForm().setFields(nameLoad);

		alertTrigger = new Button(messages.showAlert());
		asNative().addMember(alertTrigger);

		greetingTrigger = new Button(messages.greet());
		asNative().addMember(greetingTrigger);

		greetingDisplay = new Label("");
		asNative().addMember(greetingDisplay);
		greetingDisplay.setSize("213px", "60px");

		showLocation = new Button(messages.getPosition());
		asNative().addMember(showLocation);

		backTrigger = new Button(messages.back());
		asNative().addMember(backTrigger);
	}

	@Override
	public HasClickHandler getAlertTrigger() {
		return new HasClickHandlersAdapter(alertTrigger);
	}

	@Override
	public HasClickHandler getGreetingTrigger() {
		return new HasClickHandlersAdapter(greetingTrigger);
	}

	@Override
	public TakesValue<String> getNameLoad() {
		return new FormItemAdapter<String>(nameLoad);
	}

	@Override
	public TakesValue<String> getGreetingDisplay() {
		return new LabelAdapter(greetingDisplay);
	}

	@Override
	public HasClickHandler getBackTrigger() {
		return new HasClickHandlersAdapter(backTrigger);
	}

	@Override
	public HasClickHandler getShowLocation() {
		return new HasClickHandlersAdapter(showLocation);
	}
}
