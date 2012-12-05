package ar.com.oxen.nibiru.mobile.gwt.ui.mvp;

import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ChangeHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasChangeHandler;
import ar.com.oxen.nibiru.mobile.gwt.handler.HandlerRegistrationAdapter;

import com.google.gwt.event.dom.client.HasChangeHandlers;

public class HasChangeHandlersAdapter implements HasChangeHandler {
	private HasChangeHandlers hasChangeHandlers;
	private HandlerRegistration changeHandlerRegistration;

	public HasChangeHandlersAdapter(HasChangeHandlers hasChangeHandlers) {
		super();
		this.hasChangeHandlers = hasChangeHandlers;
	}

	@Override
	public HandlerRegistration setChangeHandler(
			final ChangeHandler changeHandler) {
		if (this.changeHandlerRegistration != null) {
			this.changeHandlerRegistration.removeHandler();
		}

		this.changeHandlerRegistration = new HandlerRegistrationAdapter(
				this.hasChangeHandlers
						.addChangeHandler(new ChangeHandlerAdapter<Object>(
								changeHandler)));

		return this.changeHandlerRegistration;
	}
}
