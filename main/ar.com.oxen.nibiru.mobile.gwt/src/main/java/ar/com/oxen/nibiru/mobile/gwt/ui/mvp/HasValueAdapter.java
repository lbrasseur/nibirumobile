package ar.com.oxen.nibiru.mobile.gwt.ui.mvp;

import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ChangeHandler;
import ar.com.oxen.nibiru.mobile.gwt.handler.HandlerRegistrationAdapter;

import com.google.gwt.user.client.ui.HasValue;

public class HasValueAdapter<T> implements
		ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasValue<T> {
	private HasValue<T> hasValue;
	private HandlerRegistration changeHandlerRegistration;

	public HasValueAdapter(HasValue<T> hasValue) {
		super();
		this.hasValue = hasValue;
	}

	@Override
	public void setValue(T value) {
		this.hasValue.setValue(value);
	}

	@Override
	public T getValue() {
		return this.hasValue.getValue();
	}

	@Override
	public HandlerRegistration setChangeHandler(ChangeHandler changeHandler) {
		if (this.changeHandlerRegistration != null) {
			this.changeHandlerRegistration.removeHandler();
		}

		this.changeHandlerRegistration = new HandlerRegistrationAdapter(
				this.hasValue
						.addValueChangeHandler(new ChangeHandlerAdapter<T>(
								changeHandler)));

		return this.changeHandlerRegistration;

	}
}
