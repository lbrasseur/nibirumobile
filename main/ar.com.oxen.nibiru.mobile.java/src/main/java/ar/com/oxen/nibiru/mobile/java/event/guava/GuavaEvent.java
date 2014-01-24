package ar.com.oxen.nibiru.mobile.java.event.guava;

import static com.google.common.base.Preconditions.checkNotNull;
import ar.com.oxen.nibiru.mobile.core.api.event.Event;
import ar.com.oxen.nibiru.mobile.core.impl.common.BaseConfigurable;

import com.google.common.eventbus.EventBus;

class GuavaEvent extends BaseConfigurable<Event> implements Event {
	private final String id;
	private final EventBus eventBus;

	GuavaEvent(String id, EventBus eventBus) {
		this.id = checkNotNull(id);
		this.eventBus = checkNotNull(eventBus);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public <T> T getParameter(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event addParameter(String key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub
		
	}
}
