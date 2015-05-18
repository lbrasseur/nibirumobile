package ar.com.oxen.nibiru.mobile.sample.wp.ui;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.HasClickHandlersAdapter;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.MainMenuPresenter.Display;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SampleMessages;
import ar.com.oxen.nibiru.mobile.wp.ui.mvp.BaseWindowsPhoneView;

import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.ui.Button;

public class MainMenuDisplay extends BaseWindowsPhoneView implements Display {
	private final Button customerManagement;
	private final Button samples;

	@Inject
	public MainMenuDisplay(SampleMessages messages) {
		label("title").setText(messages.title());
		customerManagement = button("customerManagement");
		customerManagement.setText(messages.customerManagement());
		samples = Button.wrap(Document.get().getElementById("samples"));
		samples.setText(messages.samples());
	}

	@Override
	public HasClickHandler getCustomerManagement() {
		return new HasClickHandlersAdapter(customerManagement);
	}

	@Override
	public HasClickHandler getSamples() {
		return new HasClickHandlersAdapter(samples);
	}
}
