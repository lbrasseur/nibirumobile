package ar.com.oxen.nibiru.mobile.sample.mgwt.client;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.BaseGwtView;
import ar.com.oxen.nibiru.mobile.mgwt.ui.mvp.HasTapHandlersAdapter;
import ar.com.oxen.nibiru.mobile.sample.app.ui.MainMenuPresenter.Display;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SampleMessages;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.mgwt.ui.client.widget.button.Button;

public class MainMenuDisplay extends BaseGwtView implements Display {
	private final Button userManagement;
	private final Button samples;

	@Inject
	public MainMenuDisplay(SampleMessages messages) {
		checkNotNull(messages);

		FlowPanel container = new FlowPanel();
		initWidget(container);

		container.add(new Label(messages.title()));

		userManagement = new Button(messages.userManagement());
		container.add(userManagement);

		samples = new Button(messages.samples());
		container.add(samples);
	}

	@Override
	public HasClickHandler getUserManagement() {
		return new HasTapHandlersAdapter(userManagement);
	}

	@Override
	public HasClickHandler getSamples() {
		return new HasTapHandlersAdapter(samples);
	}
}
