package ar.com.oxen.nibiru.mobile.smartgwt.ui.place;

import java.util.HashMap;
import java.util.Map;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.Presenter;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.View;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;

import com.smartgwt.mobile.client.internal.util.AnimationUtil.Direction;
import com.smartgwt.mobile.client.widgets.Panel;
import com.smartgwt.mobile.client.widgets.layout.NavStack;

public class NavStackPlace implements Place {
	private String id;
	private NavStack<?> navStack;
	private PresenterMapper presenterMapper;
	private Map<String, Object> parameters;

	public NavStackPlace(String id, NavStack<?> navStack,
			PresenterMapper presenterMapper) {
		super();
		this.id = id;
		this.navStack = navStack;
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
		Panel view = (Panel) presenter.getView().asNative();
		if (!push && this.navStack.size() > 0) {
			this.navStack.popTo(this.navStack.get(0), Direction.RIGHT);
			// TODO: Esto vuelve al primer elemento, pero no lo cierra 
		}
		this.navStack.push(view);
		presenter.go(this);
	}
}
