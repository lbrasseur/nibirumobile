package ar.com.oxen.nibiru.mobile.gwt.ui.mvp;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ChangeHandler;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

public class ChangeHandlerAdapter<T> implements
		com.google.gwt.event.dom.client.ChangeHandler, ValueChangeHandler<T> {
	private final ChangeHandler changeHandler;

	public ChangeHandlerAdapter(ChangeHandler changeHandler) {
		this.changeHandler = changeHandler;
	}

	@Override
	public void onChange(ChangeEvent event) {
		this.changeHandler.onChange();
	}

	@Override
	public void onValueChange(ValueChangeEvent<T> event) {
		this.changeHandler.onChange();
	}
}