package ar.com.oxen.nibiru.mobile.sample.mgwt.client;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.mgwt.ui.mvp.BaseFormView;
import ar.com.oxen.nibiru.mobile.mgwt.ui.mvp.HasTapHandlersAdapter;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SampleMessages;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SecondPresenter.Display;

import com.googlecode.mgwt.ui.client.widget.button.Button;

public class SecondDisplay extends BaseFormView implements Display {
	private final Button backTrigger;

	@Inject
	public SecondDisplay(SampleMessages messages) {
		checkNotNull(messages);
		backTrigger = new Button(messages.back());
		getFormPanel().add(backTrigger);
		backTrigger.setSize("78px", "19px");
	}

	@Override
	public HasClickHandler getBackTrigger() {
		return new HasTapHandlersAdapter(backTrigger);
	}
}
