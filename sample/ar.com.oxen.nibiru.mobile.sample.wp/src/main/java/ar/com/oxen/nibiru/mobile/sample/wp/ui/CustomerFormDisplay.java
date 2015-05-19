package ar.com.oxen.nibiru.mobile.sample.wp.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.TakesValue;
import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.HasClickHandlersAdapter;
import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.TakesValueAdapter;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.CustomerFormPresenter.Display;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SampleMessages;
import ar.com.oxen.nibiru.mobile.wp.ui.mvp.BaseWindowsPhoneView;

import com.google.gwt.user.client.ui.Button;

public class CustomerFormDisplay extends BaseWindowsPhoneView implements
		Display {

	private final Button save;
	private final Button cancel;

	@Inject
	public CustomerFormDisplay(SampleMessages messages) {
		checkNotNull(messages);
		label("firstNameLabel").setText(messages.firstName());
		label("lastNameLabel").setText(messages.lastName());
		save = button("save");
		save.setText(messages.save());
		cancel = button("cancel");
		cancel.setText(messages.cancel());
	}

	@Override
	public TakesValue<String> getFirstName() {
		return new TakesValueAdapter<>(textBox("firstName"));
	}

	@Override
	public TakesValue<String> getLastName() {
		return new TakesValueAdapter<>(textBox("lastName"));
	}

	@Override
	public HasClickHandler getSave() {
		return new HasClickHandlersAdapter(save);
	}

	@Override
	public HasClickHandler getCancel() {
		return new HasClickHandlersAdapter(cancel);
	}
}
