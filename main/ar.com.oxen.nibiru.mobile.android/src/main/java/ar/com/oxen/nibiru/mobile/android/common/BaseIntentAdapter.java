package ar.com.oxen.nibiru.mobile.android.common;

import java.io.Serializable;

import android.content.Intent;
import ar.com.oxen.nibiru.mobile.core.api.common.Configurable;
import ar.com.oxen.nibiru.mobile.core.api.common.Identifiable;
import ar.com.oxen.nibiru.mobile.core.impl.common.AbstractConfigurable;

public abstract class BaseIntentAdapter<T> extends AbstractConfigurable<T>
		implements Identifiable<String>, Configurable<T> {
	private final String KEY_ID = "nibiruKeyId";
	private Intent intent;

	public BaseIntentAdapter(Intent intent) {
		super();
		this.intent = intent;
	}

	public BaseIntentAdapter(String id, Intent intent) {
		this(intent);
		this.intent.putExtra(KEY_ID, id);
	}

	@Override
	public String getId() {
		return this.intent.getExtras().getString(KEY_ID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <K> K getParameter(String key) {
		return (K) this.intent.getExtras().get(key);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T addParameter(String key, Object value) {
		this.intent.putExtra(key, (Serializable) value);
		return (T) this;
	}

	protected Intent getIntent() {
		return intent;
	}
}
