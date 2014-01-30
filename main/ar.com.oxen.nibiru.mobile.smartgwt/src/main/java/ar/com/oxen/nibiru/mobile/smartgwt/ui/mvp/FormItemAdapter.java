package ar.com.oxen.nibiru.mobile.smartgwt.ui.mvp;

import static com.google.common.base.Preconditions.checkNotNull;
import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ChangeHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasValue;
import ar.com.oxen.nibiru.mobile.gwt.handler.HandlerRegistrationAdapter;

import com.smartgwt.mobile.client.widgets.form.fields.FormItem;

public class FormItemAdapter<V> implements HasValue<V> {
	private final FormItem formItem;
	private HandlerRegistration changeHandlerRegistration;

	public FormItemAdapter(FormItem formItem) {
		this.formItem = checkNotNull(formItem);
	}

	@Override
	public void setValue(V value) {
		formItem.setValue(value);
	}

	@SuppressWarnings("unchecked")
	@Override
	public V getValue() {
		return (V) formItem.getValue();
	}

	@Override
	public HandlerRegistration setChangeHandler(ChangeHandler changeHandler) {
		if (changeHandlerRegistration != null) {
			changeHandlerRegistration.removeHandler();
		}
		changeHandlerRegistration = new HandlerRegistrationAdapter(
				formItem.addChangedHandler(new ChangeHandlerAdapter(
						changeHandler)));
		return changeHandlerRegistration;
	}
}
