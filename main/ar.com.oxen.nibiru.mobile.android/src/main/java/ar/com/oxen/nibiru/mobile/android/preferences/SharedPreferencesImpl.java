package ar.com.oxen.nibiru.mobile.android.preferences;

import javax.inject.Inject;

import android.content.Context;
import android.content.SharedPreferences;
import ar.com.oxen.nibiru.mobile.core.api.preferences.Preferences;
import ar.com.oxen.nibiru.mobile.core.impl.preferences.AbstractPreferences;

public class SharedPreferencesImpl extends AbstractPreferences {
	private SharedPreferences sharedPreferences;

	@Inject
	public SharedPreferencesImpl(Context context) {
		super();
		this.sharedPreferences = context.getSharedPreferences(
				"NibiruPreferences", Context.MODE_PRIVATE);
	}

	@Override
	public <T> T getParameter(String key) {
		return this.objectFromString(this.sharedPreferences
				.getString(key, null));
	}

	@Override
	public Preferences addParameter(String key, Object value) {
		SharedPreferences.Editor editor = this.sharedPreferences.edit();
		editor.putString(key, this.stringFromObject(value));
		editor.commit();
		return this;
	}
}
