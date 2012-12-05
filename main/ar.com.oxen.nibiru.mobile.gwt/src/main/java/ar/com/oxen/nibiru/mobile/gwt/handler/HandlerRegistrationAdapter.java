package ar.com.oxen.nibiru.mobile.gwt.handler;

import com.google.web.bindery.event.shared.HandlerRegistration;

public class HandlerRegistrationAdapter implements
		ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration {
	private HandlerRegistration handlerRegistration;

	public HandlerRegistrationAdapter(HandlerRegistration handlerRegistration) {
		super();
		this.handlerRegistration = handlerRegistration;
	}

	@Override
	public void removeHandler() {
		this.handlerRegistration.removeHandler();
	}
}
