package ar.com.oxen.nibiru.mobile.kendoui.ui.place;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.Presenter;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.View;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;

import com.google.common.collect.Maps;

public class KendoUiPlace implements Place {
	private final static String KENDO_ELEMENT_ID = "nibiruKendoView";
	private final String id;
	private final PresenterMapper presenterMapper;
	private final Map<String, Object> parameters;

	public KendoUiPlace(String id, PresenterMapper presenterMapper) {
		this.id = checkNotNull(id);
		this.presenterMapper = checkNotNull(presenterMapper);
		this.parameters = Maps.newHashMap();
	}

	@Override
	public String getId() {
		return id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getParameter(String key) {
		return (T) parameters.get(key);
	}

	@Override
	public <T> T getParameter(Enum<?> key) {
		return getParameter(key.toString());
	}

	@Override
	public Place addParameter(String key, Object value) {
		parameters.put(key, value);
		return this;
	}

	@Override
	public Place addParameter(Enum<?> key, Object value) {
		return addParameter(key.toString(), value);
	}

	@Override
	public void go() {
		go(false);
	}

	@Override
	public void go(boolean push) {
		Presenter<? extends View> presenter = presenterMapper
				.getPresenter(id);
		navigate(id);
		presenter.go(this);
	}
	
	private native void navigate(String place) /*-{
		$wnd.kendoMobileApplication.navigate("#" + place);
	}-*/;

}
