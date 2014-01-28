package ar.com.oxen.nibiru.mobile.gwt.ui.mvp;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.gwt.user.client.TakesValue;

public class TakesValueAdapter<T> implements
		ar.com.oxen.nibiru.mobile.core.api.ui.mvp.TakesValue<T> {
	private final TakesValue<T> takesValue;

	public TakesValueAdapter(TakesValue<T> takesValue) {
		this.takesValue = checkNotNull(takesValue);
	}

	@Override
	public void setValue(T value) {
		checkNotNull(value);
		takesValue.setValue(value);
	}

	@Override
	public T getValue() {
		return takesValue.getValue();
	}
}
