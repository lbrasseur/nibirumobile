package ar.com.oxen.nibiru.mobile.gwt.handler;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.web.bindery.event.shared.HandlerRegistration;

public class HandlerRegistrationAdapter implements
		ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration {
	private final HandlerRegistration handlerRegistration;

	public HandlerRegistrationAdapter(HandlerRegistration handlerRegistration) {
		this.handlerRegistration = checkNotNull(handlerRegistration);
	}

	@Override
	public void removeHandler() {
		handlerRegistration.removeHandler();
	}
}
