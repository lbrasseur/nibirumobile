package ar.com.oxen.nibiru.mobile.sample.app.ui;

import javax.inject.Inject;
import javax.inject.Provider;

import ar.com.oxen.nibiru.mobile.core.api.ui.place.DefaultPlaces;
import ar.com.oxen.nibiru.mobile.core.impl.mvp.BasePresenterMapper;
import ar.com.oxen.nibiru.mobile.core.impl.ui.security.LoginPresenter;

public class SamplePresenterMapper extends BasePresenterMapper {
	@Inject
	public SamplePresenterMapper(Provider<LoginPresenter> loginPresenter,
			Provider<SamplePresenter> samplePresenter) {
		super();
		this.map(DefaultPlaces.LOGIN, loginPresenter);
		this.map(DefaultPlaces.HOME, samplePresenter);
	}
}
