package ar.com.oxen.nibiru.mobile.sample.kendoui.client;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.HasClickHandlersAdapter;
import ar.com.oxen.nibiru.mobile.kendoui.ui.mvp.BaseFormView;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SampleMessages;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SecondPresenter.Display;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Widget;

public class SecondDisplay extends BaseFormView implements Display {
	public interface SampleDisplayUiBinder extends
			UiBinder<Widget, SecondDisplay> {
	}

	@UiField
	Anchor backTrigger;

	@Inject
	public SecondDisplay(SampleDisplayUiBinder uiBinder, SampleMessages messages) {
		checkNotNull(uiBinder);
		checkNotNull(messages);
		initWidget(uiBinder.createAndBindUi(this));
		backTrigger.setText(messages.back());
	}

	@Override
	public HasClickHandler getBackTrigger() {
		return new HasClickHandlersAdapter(backTrigger);
	}
}
