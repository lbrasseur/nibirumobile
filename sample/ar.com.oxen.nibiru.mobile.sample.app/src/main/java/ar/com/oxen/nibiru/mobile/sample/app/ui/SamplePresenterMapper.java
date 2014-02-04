package ar.com.oxen.nibiru.mobile.sample.app.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import ar.com.oxen.nibiru.mobile.core.api.ui.place.DefaultPlaces;
import ar.com.oxen.nibiru.mobile.core.impl.mvp.BasePresenterMapper;
import ar.com.oxen.nibiru.mobile.core.impl.ui.security.LoginPresenter;

public class SamplePresenterMapper extends BasePresenterMapper {
	@Inject
	public SamplePresenterMapper(Provider<LoginPresenter> loginPresenter,
			Provider<SamplePresenter> samplePresenter,
			Provider<SecondPresenter> secondPresenter) {
		checkNotNull(loginPresenter);
		checkNotNull(samplePresenter);
		map(DefaultPlaces.LOGIN, loginPresenter);
		map(DefaultPlaces.HOME, samplePresenter);
		map(SamplePlaces.SECOND, secondPresenter);
	}
}
