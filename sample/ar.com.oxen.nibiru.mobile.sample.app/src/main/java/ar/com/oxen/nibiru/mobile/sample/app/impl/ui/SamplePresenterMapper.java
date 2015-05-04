package ar.com.oxen.nibiru.mobile.sample.app.impl.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import ar.com.oxen.nibiru.mobile.core.api.ui.place.DefaultPlaces;
import ar.com.oxen.nibiru.mobile.core.impl.mvp.BasePresenterMapper;
import ar.com.oxen.nibiru.mobile.security.core.impl.ui.LoginPresenter;

public class SamplePresenterMapper extends BasePresenterMapper {
	@Inject
	public SamplePresenterMapper(Provider<LoginPresenter> loginPresenter,
			Provider<MainMenuPresenter> mainMenuPresenter,
			Provider<CustomerManagementPresenter> customerManagementPresenter,
			Provider<CustomerFormPresenter> customerFormPresenter,
			Provider<SamplePresenter> samplePresenter,
			Provider<SecondPresenter> secondPresenter) {
		checkNotNull(loginPresenter);
		checkNotNull(samplePresenter);
		map(DefaultPlaces.LOGIN, loginPresenter);
		map(DefaultPlaces.HOME, mainMenuPresenter);
		map(Places.CUSTOMER_MANAGEMENT, customerManagementPresenter);
		map(Places.CUSTOMER_FORM, customerFormPresenter);
		map(Places.SAMPLES, samplePresenter);
		map(Places.SECOND, secondPresenter);
	}
}
