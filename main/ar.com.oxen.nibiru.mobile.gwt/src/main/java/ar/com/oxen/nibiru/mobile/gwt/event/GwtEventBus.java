package ar.com.oxen.nibiru.mobile.gwt.event;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.event.Event;
import ar.com.oxen.nibiru.mobile.core.api.event.EventBus;
import ar.com.oxen.nibiru.mobile.core.api.event.EventHandler;
import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.gwt.handler.HandlerRegistrationAdapter;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class GwtEventBus implements EventBus {
	private com.google.web.bindery.event.shared.EventBus eventBus;
	private Map<String, GwtEvent.Type<SimpleEventHandler>> eventTypes;

	@Inject
	public GwtEventBus(com.google.web.bindery.event.shared.EventBus eventBus) {
		super();
		this.eventBus = eventBus;
		this.eventTypes = new HashMap<String, GwtEvent.Type<SimpleEventHandler>>();
	}

	@Override
	public Event createEvent(String id) {
		return new SimpleEvent(id, this.getType(id), this.eventBus);
	}

	@Override
	public Event createEvent(Enum<?> id) {
		return this.createEvent(id.toString());
	}

	@Override
	public HandlerRegistration addHandler(String event,
			final EventHandler handler) {
		return new HandlerRegistrationAdapter(this.eventBus.addHandler(
				this.getType(event), new SimpleEventHandler() {
					@Override
					public void onEvent(SimpleEvent event) {
						handler.onEvent(event);
					}
				}));
	}

	@Override
	public HandlerRegistration addHandler(Enum<?> eventId, EventHandler handler) {
		return this.addHandler(eventId.toString(), handler);
	}

	private GwtEvent.Type<SimpleEventHandler> getType(String event) {
		GwtEvent.Type<SimpleEventHandler> type = this.eventTypes.get(event);
		if (type == null) {
			type = new Type<SimpleEventHandler>();
			this.eventTypes.put(event, type);
		}
		return type;
	}
}
