package ar.com.oxen.nibiru.mobile.gwt.ui.mvp;

import static com.google.common.base.Preconditions.checkNotNull;
import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ChangeHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasChangeHandler;
import ar.com.oxen.nibiru.mobile.gwt.handler.HandlerRegistrationAdapter;

import com.google.gwt.event.dom.client.HasChangeHandlers;

public class HasChangeHandlersAdapter implements HasChangeHandler {
	private final HasChangeHandlers hasChangeHandlers;
	private HandlerRegistration changeHandlerRegistration;

	public HasChangeHandlersAdapter(HasChangeHandlers hasChangeHandlers) {
		this.hasChangeHandlers = checkNotNull(hasChangeHandlers);
	}

	@Override
	public HandlerRegistration setChangeHandler(
			final ChangeHandler changeHandler) {
		checkNotNull(changeHandler);
		if (changeHandlerRegistration != null) {
			changeHandlerRegistration.removeHandler();
		}

		changeHandlerRegistration = new HandlerRegistrationAdapter(
				hasChangeHandlers
						.addChangeHandler(new ChangeHandlerAdapter<Object>(
								changeHandler)));

		return changeHandlerRegistration;
	}
}
