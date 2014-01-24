package ar.com.oxen.nibiru.mobile.smartgwt.ui.place;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.HashMap;
import java.util.Map;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.Presenter;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.View;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;
import ar.com.oxen.nibiru.mobile.core.impl.common.BaseConfigurable;

import com.smartgwt.mobile.client.internal.util.AnimationUtil.Direction;
import com.smartgwt.mobile.client.widgets.Panel;
import com.smartgwt.mobile.client.widgets.layout.NavStack;

public class NavStackPlace extends BaseConfigurable<Place> implements Place {
	private final String id;
	private final NavStack<?> navStack;
	private final PresenterMapper presenterMapper;
	private final Map<String, Object> parameters;

	public NavStackPlace(String id, NavStack<?> navStack,
			PresenterMapper presenterMapper) {
		this.id = checkNotNull(id);
		this.navStack = checkNotNull(navStack);
		this.presenterMapper = checkNotNull(presenterMapper);
		parameters = new HashMap<String, Object>();
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
	public Place addParameter(String key, Object value) {
		checkNotNull(key);
		checkNotNull(value);
		parameters.put(key, value);
		return this;
	}

	@Override
	public void go() {
		go(false);
	}

	@Override
	public void go(boolean push) {
		Presenter<? extends View> presenter = presenterMapper.getPresenter(id);
		Panel view = (Panel) presenter.getView().asNative();
		if (!push && navStack.size() > 0) {
			navStack.popTo(navStack.get(0), Direction.RIGHT);
			// TODO: Esto vuelve al primer elemento, pero no lo cierra
		}
		navStack.push(view);
		presenter.go(this);
	}
}
