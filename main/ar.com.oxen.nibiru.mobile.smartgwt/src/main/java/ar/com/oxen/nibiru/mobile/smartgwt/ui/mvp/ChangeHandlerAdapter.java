package ar.com.oxen.nibiru.mobile.smartgwt.ui.mvp;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ChangeHandler;

import com.smartgwt.mobile.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.mobile.client.widgets.form.fields.events.ChangedHandler;

public class ChangeHandlerAdapter implements ChangedHandler  {
	private ChangeHandler changeHandler;

	public ChangeHandlerAdapter(ChangeHandler changeHandler) {
		super();
		this.changeHandler = changeHandler;
	}

	@Override
	public void onChanged(ChangedEvent event) {
		this.changeHandler.onChange();
	}
}
