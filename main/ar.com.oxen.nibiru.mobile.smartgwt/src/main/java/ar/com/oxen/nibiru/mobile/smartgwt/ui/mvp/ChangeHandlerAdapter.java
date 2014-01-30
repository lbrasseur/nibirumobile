package ar.com.oxen.nibiru.mobile.smartgwt.ui.mvp;

import static com.google.common.base.Preconditions.checkNotNull;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ChangeHandler;

import com.smartgwt.mobile.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.mobile.client.widgets.form.fields.events.ChangedHandler;

public class ChangeHandlerAdapter implements ChangedHandler  {
	private final ChangeHandler changeHandler;

	public ChangeHandlerAdapter(ChangeHandler changeHandler) {
		this.changeHandler = checkNotNull(changeHandler);
	}

	@Override
	public void onChanged(ChangedEvent event) {
		changeHandler.onChange();
	}
}
