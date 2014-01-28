package ar.com.oxen.nibiru.mobile.gwt.ui.mvp;

import static com.google.common.base.Preconditions.checkNotNull;
import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ChangeHandler;
import ar.com.oxen.nibiru.mobile.gwt.handler.HandlerRegistrationAdapter;

import com.google.gwt.user.client.ui.HasValue;

public class HasValueAdapter<T> implements
		ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasValue<T> {
	private final HasValue<T> hasValue;
	private HandlerRegistration changeHandlerRegistration;

	public HasValueAdapter(HasValue<T> hasValue) {
		this.hasValue = checkNotNull(hasValue);
	}

	@Override
	public void setValue(T value) {
		checkNotNull(value);
		hasValue.setValue(value);
	}

	@Override
	public T getValue() {
		return hasValue.getValue();
	}

	@Override
	public HandlerRegistration setChangeHandler(ChangeHandler changeHandler) {
		checkNotNull(changeHandler);
		if (changeHandlerRegistration != null) {
			changeHandlerRegistration.removeHandler();
		}

		changeHandlerRegistration = new HandlerRegistrationAdapter(
				hasValue.addValueChangeHandler(new ChangeHandlerAdapter<T>(
						changeHandler)));

		return changeHandlerRegistration;
	}
}
