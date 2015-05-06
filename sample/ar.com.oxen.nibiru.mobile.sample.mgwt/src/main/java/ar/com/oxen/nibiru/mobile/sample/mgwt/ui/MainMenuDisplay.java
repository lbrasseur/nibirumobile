package ar.com.oxen.nibiru.mobile.sample.mgwt.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.BaseGwtView;
import ar.com.oxen.nibiru.mobile.mgwt.ui.mvp.HasTapHandlersAdapter;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.MainMenuPresenter.Display;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.button.Button;

public class MainMenuDisplay extends BaseGwtView implements Display {
	interface MainMenuDisplayUiBinder extends UiBinder<Widget, MainMenuDisplay> {
	}

	@UiField
	Button customerManagement;

	@UiField
	Button samples;

	@Inject
	public MainMenuDisplay(MainMenuDisplayUiBinder uiBinder) {
		checkNotNull(uiBinder);
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public HasClickHandler getCustomerManagement() {
		return new HasTapHandlersAdapter(customerManagement);
	}

	@Override
	public HasClickHandler getSamples() {
		return new HasTapHandlersAdapter(samples);
	}
}
