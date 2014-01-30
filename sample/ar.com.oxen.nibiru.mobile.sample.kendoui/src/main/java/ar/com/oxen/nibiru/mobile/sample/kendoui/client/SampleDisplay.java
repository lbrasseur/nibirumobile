package ar.com.oxen.nibiru.mobile.sample.kendoui.client;

import static com.google.common.base.Preconditions.checkNotNull;

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
		checkNotNull(uiBinder);
		checkNotNull(messages);
		initWidget(uiBinder.createAndBindUi(this));

		nameLoad.setText(messages.title());
		nameLoad.setValue("Pepe");

		alertTrigger.setText(messages.showAlert());

		greetingTrigger.setText(messages.greet());

		showLocation.setText(messages.getPosition());

		backTrigger.setText(messages.back());
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
		return new TakesValueAdapter<String>(nameLoad);
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
