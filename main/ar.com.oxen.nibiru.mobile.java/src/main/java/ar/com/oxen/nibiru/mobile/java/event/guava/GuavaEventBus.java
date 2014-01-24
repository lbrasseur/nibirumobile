package ar.com.oxen.nibiru.mobile.java.event.guava;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.event.Event;
import ar.com.oxen.nibiru.mobile.core.api.event.EventHandler;
import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

public class GuavaEventBus implements
		ar.com.oxen.nibiru.mobile.core.api.event.EventBus {
	private final EventBus eventBus;
	private final Multimap<String, EventHandler> handlers;

	@Inject
	public GuavaEventBus(EventBus eventBus) {
		this.eventBus = checkNotNull(eventBus);
		handlers = HashMultimap.create();
		eventBus.register(this);
	}

	@Override
	public Event createEvent(String id) {
		checkNotNull(id);
		return new GuavaEvent(id, eventBus);
	}

	@Override
	public Event createEvent(Enum<?> id) {
		checkNotNull(id);
		return createEvent(id.toString());
	}

	@Override
	public HandlerRegistration addHandler(final String eventId,
			final EventHandler handler) {
		handlers.put(eventId, handler);
		return new HandlerRegistration() {
			@Override
			public void removeHandler() {
				handlers.remove(eventId, handler);
			}
		};
	}

	@Override
	public HandlerRegistration addHandler(Enum<?> eventId, EventHandler handler) {
		checkNotNull(eventId);
		checkNotNull(handler);
		return addHandler(eventId.toString(), handler);
	}

	@Subscribe
	public void onEvent(GuavaEvent event) {
		checkNotNull(event);
		for (EventHandler handler : handlers.get(event.getId())) {
			handler.onEvent(event);
		}
	}
}
