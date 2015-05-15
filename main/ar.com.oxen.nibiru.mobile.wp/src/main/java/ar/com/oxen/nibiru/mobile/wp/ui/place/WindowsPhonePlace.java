package ar.com.oxen.nibiru.mobile.wp.ui.place;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import ar.com.oxen.nibiru.mobile.core.api.common.Identifiable;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;
import ar.com.oxen.nibiru.mobile.core.impl.common.BaseConfigurable;

import com.google.common.collect.Maps;

public class WindowsPhonePlace  extends BaseConfigurable<Place>
implements Place, Identifiable<String> {
	private final String id;
	private final Map<String, Object> parameters;
	private final int order;

	public WindowsPhonePlace(String id, int order) {
		this.id = checkNotNull(id);
		this.parameters = Maps.newHashMap();
		this.order = order;
	}

	@Override
	public String getId() {
		return id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getParameter(String key) {
		checkNotNull(key);
		return (T) parameters.get(key);
	}

	@Override
	public <T> T getParameter(Enum<?> key) {
		checkNotNull(key);
		return getParameter(key.toString());
	}

	@Override
	public Place addParameter(String key, Object value) {
		checkNotNull(key);
		checkNotNull(value);
		parameters.put(key, value);
		return this;
	}

	@Override
	public Place addParameter(Enum<?> key, Object value) {
		checkNotNull(key);
		checkNotNull(value);
		return addParameter(key.toString(), value);
	}

	@Override
	public void go(boolean push) {
		navigate(id.toLowerCase());
	}

	@Override
	public void go() {
		go(false);
	}

	public boolean forwardFrom(WindowsPhonePlace other) {
		checkNotNull(other);
		return order > other.order;
	}

	private static native void navigate(String page) /*-{
	  $wnd.WinJS.Navigation.navigate("/pages/" + page + "/" + page + ".html");
	}-*/;

	

}
