package ar.com.oxen.nibiru.mobile.smartgwt.ui.mvp;

import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ChangeHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasValue;
import ar.com.oxen.nibiru.mobile.gwt.handler.HandlerRegistrationAdapter;

import com.smartgwt.mobile.client.widgets.form.fields.FormItem;

public class FormItemAdapter<V> implements HasValue<V> {
	private FormItem formItem;
	private HandlerRegistration changeHandlerRegistration;

	public FormItemAdapter(FormItem formItem) {
		super();
		this.formItem = formItem;
	}

	@Override
	public void setValue(V value) {
		this.formItem.setValue(value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public V getValue() {
		return (V) this.formItem.getValue();
	}

	@Override
	public HandlerRegistration setChangeHandler(ChangeHandler changeHandler) {
		if (this.changeHandlerRegistration != null) {
			this.changeHandlerRegistration.removeHandler();
		}
		this.changeHandlerRegistration = new HandlerRegistrationAdapter(
				this.formItem.addChangedHandler(new ChangeHandlerAdapter(
						changeHandler)));
		return this.changeHandlerRegistration;
	}
}
