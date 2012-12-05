package ar.com.oxen.nibiru.mobile.kendoui.ui.place;

import java.util.HashMap;
import java.util.Map;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.Presenter;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.View;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;

public class KendoUiPlace implements Place {
	private final static String KENDO_ELEMENT_ID = "nibiruKendoView";
	private String id;
	private PresenterMapper presenterMapper;
	private Map<String, Object> parameters;

	public KendoUiPlace(String id, 
			PresenterMapper presenterMapper) {
		super();
		this.id = id;
		this.presenterMapper = presenterMapper;
		this.parameters = new HashMap<String, Object>();
	}

	@Override
	public String getId() {
		return this.id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getParameter(String key) {
		return (T) this.parameters.get(key);
	}

	@Override
	public <T> T getParameter(Enum<?> key) {
		return this.getParameter(key.toString());
	}

	@Override
	public Place addParameter(String key, Object value) {
		this.parameters.put(key, value);
		return this;
	}

	@Override
	public Place addParameter(Enum<?> key, Object value) {
		return this.addParameter(key.toString(), value);
	}

	@Override
	public void go() {
		this.go(false);
	}

	@Override
	public void go(boolean push) {
		Presenter<? extends View> presenter = this.presenterMapper
				.getPresenter(this.id);
		this.navigate(this.id);
		presenter.go(this);
	}
	
	private native void navigate(String place) /*-{
		$wnd.kendoMobileApplication.navigate("#" + place);
	}-*/;

}
