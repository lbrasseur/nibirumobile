package ar.com.oxen.nibiru.mobile.core.impl.mvp;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Provider;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.NoPresenterFoundException;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.Presenter;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.PresenterMapper;

public class BasePresenterMapper implements PresenterMapper {
	private Map<String, Provider<?>> providers = new HashMap<String, Provider<?>>();

	protected <T extends Presenter<?>> void map(String place,
			Provider<T> presenter) {
		this.providers.put(place, presenter);
	}

	protected <T extends Presenter<?>> void map(Enum<?> place,
			Provider<T> presenter) {
		this.map(place.toString(), presenter);
	}

	@Override
	public Presenter<?> getPresenter(String place) {
		if (!this.providers.containsKey(place)) {
			throw new NoPresenterFoundException(place);
		}
		return (Presenter<?>) this.providers.get(place).get();
	}
}
