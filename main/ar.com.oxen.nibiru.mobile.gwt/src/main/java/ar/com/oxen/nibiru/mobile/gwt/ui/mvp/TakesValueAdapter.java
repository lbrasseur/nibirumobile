package ar.com.oxen.nibiru.mobile.gwt.ui.mvp;

import com.google.gwt.user.client.TakesValue;

public class TakesValueAdapter<T> implements
		ar.com.oxen.nibiru.mobile.core.api.ui.mvp.TakesValue<T> {
	private TakesValue<T> takesValue;

	public TakesValueAdapter(TakesValue<T> takesValue) {
		super();
		this.takesValue = takesValue;
	}

	@Override
	public void setValue(T value) {
		this.takesValue.setValue(value);
	}

	@Override
	public T getValue() {
		return this.takesValue.getValue();
	}
}
