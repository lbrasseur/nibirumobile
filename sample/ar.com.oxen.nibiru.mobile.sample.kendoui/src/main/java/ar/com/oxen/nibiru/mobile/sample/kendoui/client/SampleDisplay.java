package ar.com.oxen.nibiru.mobile.sample.kendoui.client;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.TakesValue;
import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.HasClickHandlersAdapter;
import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.LabelAdapter;
import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.TakesValueAdapter;
import ar.com.oxen.nibiru.mobile.kendoui.ui.mvp.BaseFormView;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SampleMessages;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SamplePresenter;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class SampleDisplay extends BaseFormView implements
		SamplePresenter.Display {
	public interface SampleDisplayUiBinder extends
			UiBinder<Widget, SampleDisplay> {
	}

	@UiField
	Anchor alertTrigger;

	@UiField
	TextBox nameLoad;

	@UiField
	Label nameLoadLabel;

	@UiField
	Anchor greetingTrigger;

	@UiField
	Label greetingDisplay;

	@UiField
	Anchor backTrigger;

	@UiField
	Anchor showLocation;

	@Inject
	public SampleDisplay(SampleDisplayUiBinder uiBinder, SampleMessages messages) {
		super();
		initWidget(uiBinder.createAndBindUi(this));

		this.nameLoad.setText(messages.title());
		this.nameLoad.setValue("Pepe");

		this.alertTrigger.setText(messages.showAlert());

		this.greetingTrigger.setText(messages.greet());

		this.showLocation.setText(messages.getPosition());

		this.backTrigger.setText(messages.back());
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
		return new TakesValueAdapter<String>(this.nameLoad);
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
