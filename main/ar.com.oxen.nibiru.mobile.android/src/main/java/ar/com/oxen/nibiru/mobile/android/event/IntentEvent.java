package ar.com.oxen.nibiru.mobile.android.event;

import android.content.Context;
import android.content.Intent;
import ar.com.oxen.nibiru.mobile.android.common.BaseIntentAdapter;
import ar.com.oxen.nibiru.mobile.core.api.event.Event;

class IntentEvent extends BaseIntentAdapter<Event> implements Event {
	private Context context;

	public IntentEvent(Intent intent, Context context) {
		super(intent);
		this.context = context;
	}

	public IntentEvent(String id, Intent intent, Context context) {
		super(id, intent);
		this.context = context;
	}

	@Override
	public void fire() {
		this.context.sendBroadcast(this.getIntent());
	}
}
