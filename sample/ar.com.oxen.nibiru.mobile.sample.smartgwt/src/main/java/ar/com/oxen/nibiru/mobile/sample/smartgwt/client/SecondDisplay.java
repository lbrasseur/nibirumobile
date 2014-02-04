package ar.com.oxen.nibiru.mobile.sample.smartgwt.client;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SampleMessages;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SecondPresenter.Display;
import ar.com.oxen.nibiru.mobile.smartgwt.ui.mvp.BaseFormView;
import ar.com.oxen.nibiru.mobile.smartgwt.ui.mvp.HasClickHandlersAdapter;

import com.smartgwt.mobile.client.widgets.Button;

public class SecondDisplay extends BaseFormView implements Display {
	private final Button backTrigger;

	@Inject
	public SecondDisplay(SampleMessages messages) {
		super(checkNotNull(messages).title());
		backTrigger = new Button(messages.back());
		asNative().addMember(backTrigger);
	}

	@Override
	public HasClickHandler getBackTrigger() {
		return new HasClickHandlersAdapter(backTrigger);
	}
}
