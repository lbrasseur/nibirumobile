package ar.com.oxen.nibiru.mobile.android.common;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import android.content.Intent;
import ar.com.oxen.nibiru.mobile.core.api.common.Identifiable;
import ar.com.oxen.nibiru.mobile.core.impl.common.AbstractConfigurable;

public abstract class BaseIntentAdapter<T> extends AbstractConfigurable<T>
		implements Identifiable<String> {
	private final String ID_KEY = "nibiruPlaceId";
	private final Intent intent;

	public BaseIntentAdapter(Intent intent) {
		this.intent = checkNotNull(intent);
	}

	public BaseIntentAdapter(String id, Intent intent) {
		this(intent);
		this.intent.putExtra(ID_KEY, checkNotNull(id));
	}

	@Override
	public String getId() {
		return intent.getExtras().getString(ID_KEY);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <K> K getParameter(String key) {
		return (K) intent.getExtras().get(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T addParameter(String key, Object value) {
		intent.putExtra(key, (Serializable) value);
		return (T) this;
	}

	protected Intent getIntent() {
		return intent;
	}
}
