package ar.com.oxen.nibiru.mobile.gwt.event;

import java.util.HashMap;
import java.util.Map;

import com.google.gwt.event.shared.GwtEvent;

import ar.com.oxen.nibiru.mobile.core.api.event.Event;
import com.google.web.bindery.event.shared.EventBus;

public class SimpleEvent extends GwtEvent<SimpleEventHandler> implements Event {
	private String id;
	private GwtEvent.Type<SimpleEventHandler> associatedType;
	private EventBus eventBus;
	private Map<String, Object> parameters;

	public SimpleEvent(String id, Type<SimpleEventHandler> associatedType,
			EventBus eventBus) {
		super();
		this.id = id;
		this.associatedType = associatedType;
		this.eventBus = eventBus;
		this.parameters = new HashMap<String, Object>();
	}

	@Override
	public GwtEvent.Type<SimpleEventHandler> getAssociatedType() {
		return this.associatedType;
	}

	@Override
	protected void dispatch(SimpleEventHandler handler) {
		handler.onEvent(this);
	}

	@Override
	public String getId() {
		return this.id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getParameter(String key) {
		return (T) this.parameters.get(key);
	}

	@Override
	public <T> T getParameter(Enum<?> key) {
		return this.getParameter(key.toString());
	}

	@Override
	public Event addParameter(String key, Object value) {
		this.parameters.put(key, value);
		return this;
	}

	@Override
	public Event addParameter(Enum<?> key, Object value) {
		return this.addParameter(key.toString(), value);
	}

	@Override
	public void fire() {
		this.eventBus.fireEvent(this);
	}
}
