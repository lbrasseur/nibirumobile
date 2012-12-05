package ar.com.oxen.nibiru.mobile.android.ui.place;

import android.app.Activity;
import android.content.Intent;
import ar.com.oxen.nibiru.mobile.android.common.BaseIntentAdapter;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;

public class IntentPlace extends BaseIntentAdapter<Place> implements Place {
	private Activity activity;

	public IntentPlace(Intent intent, Activity activity) {
		super(intent);
		this.activity = activity;
	}

	public IntentPlace(String id, Intent intent, Activity activity) {
		super(id, intent);
		this.activity = activity;
	}

	@Override
	public void go(boolean push) {
		this.activity.startActivity(this.getIntent());
		if (!push) {
			this.activity.finish();
		}
	}

	@Override
	public void go() {
		this.go(false);
	}
}
