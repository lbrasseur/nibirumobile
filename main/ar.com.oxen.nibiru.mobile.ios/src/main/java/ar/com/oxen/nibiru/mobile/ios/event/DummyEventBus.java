package ar.com.oxen.nibiru.mobile.ios.event;

import ar.com.oxen.nibiru.mobile.core.api.event.Event;
import ar.com.oxen.nibiru.mobile.core.api.event.EventBus;
import ar.com.oxen.nibiru.mobile.core.api.event.EventHandler;
import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;

public class DummyEventBus implements EventBus {

	@Override
	public Event createEvent(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event createEvent(Enum<?> id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HandlerRegistration addHandler(String eventId, EventHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HandlerRegistration addHandler(Enum<?> eventId, EventHandler handler) {
		// TODO Auto-generated method stub
		return null;
	}

}
