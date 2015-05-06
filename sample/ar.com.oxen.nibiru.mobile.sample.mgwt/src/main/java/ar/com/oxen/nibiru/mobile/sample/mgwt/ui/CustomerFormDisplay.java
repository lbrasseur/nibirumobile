package ar.com.oxen.nibiru.mobile.sample.mgwt.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasValue;
import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.BaseGwtView;
import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.HasValueAdapter;
import ar.com.oxen.nibiru.mobile.mgwt.ui.mvp.HasTapHandlersAdapter;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.CustomerFormPresenter.Display;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.googlecode.mgwt.ui.client.widget.button.Button;
import com.googlecode.mgwt.ui.client.widget.input.MTextBox;

public class CustomerFormDisplay extends BaseGwtView implements Display {
	interface CustomerFormDisplayUiBinder extends
			UiBinder<Widget, CustomerFormDisplay> {
	}

	@UiField
	MTextBox firstName;

	@UiField
	MTextBox lastName;

	@UiField
	Button save;

	@UiField
	Button cancel;

	@Inject
	public CustomerFormDisplay(CustomerFormDisplayUiBinder uiBinder) {
		checkNotNull(uiBinder);
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public HasValue<String> getFirstName() {
		return new HasValueAdapter<String>(firstName);
	}

	@Override
	public HasValue<String> getLastName() {
		return new HasValueAdapter<String>(lastName);
	}

	@Override
	public HasClickHandler getSave() {
		return new HasTapHandlersAdapter(save);
	}

	@Override
	public HasClickHandler getCancel() {
		return new HasTapHandlersAdapter(cancel);
	}
}
