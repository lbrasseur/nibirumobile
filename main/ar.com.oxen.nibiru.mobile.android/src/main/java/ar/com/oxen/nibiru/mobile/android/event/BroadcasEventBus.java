package ar.com.oxen.nibiru.mobile.android.event;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import ar.com.oxen.nibiru.mobile.core.api.event.Event;
import ar.com.oxen.nibiru.mobile.core.api.event.EventBus;
import ar.com.oxen.nibiru.mobile.core.api.event.EventHandler;
import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;

public class BroadcasEventBus implements EventBus {
	private static final String EVENT_PREFIX = "ar.com.oxen.nibiru.mobile.android.event.";
	private final Context context;

	@Inject
	public BroadcasEventBus(Context context) {
		this.context = checkNotNull(context);
	}

	@Override
	public Event createEvent(String id) {
		checkNotNull(id);
		return new IntentEvent(id, new Intent(EVENT_PREFIX + id), context);
	}

	@Override
	public Event createEvent(Enum<?> id) {
		checkNotNull(id);
		return createEvent(id.toString());
	}

	@Override
	public HandlerRegistration addHandler(String event,
			final EventHandler handler) {
		checkNotNull(event);
		checkNotNull(handler);
		IntentFilter filter = new IntentFilter(EVENT_PREFIX + event);

		final BroadcastReceiver receiver = new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				handler.onEvent(new IntentEvent(intent, context));
			}
		};

		context.registerReceiver(receiver, filter);

		return new HandlerRegistration() {
			@Override
			public void removeHandler() {
				context.unregisterReceiver(receiver);
			}
		};
	}

	@Override
	public HandlerRegistration addHandler(Enum<?> eventId, EventHandler handler) {
		checkNotNull(eventId);
		checkNotNull(handler);
		return addHandler(eventId.toString(), handler);
	}
}
