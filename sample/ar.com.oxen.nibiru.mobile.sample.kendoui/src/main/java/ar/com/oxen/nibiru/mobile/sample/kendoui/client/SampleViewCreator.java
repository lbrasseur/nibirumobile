package ar.com.oxen.nibiru.mobile.sample.kendoui.client;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import ar.com.oxen.nibiru.mobile.core.api.ui.place.DefaultPlaces;
import ar.com.oxen.nibiru.mobile.core.impl.ui.security.LoginPresenter;
import ar.com.oxen.nibiru.mobile.kendoui.app.BaseViewCreator;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SamplePlaces;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SamplePresenter;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SecondPresenter;

public class SampleViewCreator extends BaseViewCreator {
	@Inject
	public SampleViewCreator(
			Provider<LoginPresenter.Display> loginDisplayProvider,
			Provider<SamplePresenter.Display> sampleDisplayProvider,
			Provider<SecondPresenter.Display> secondDisplayProvider) {
		checkNotNull(loginDisplayProvider);
		checkNotNull(sampleDisplayProvider);
		registerView(DefaultPlaces.LOGIN, loginDisplayProvider);
		registerView(DefaultPlaces.HOME, sampleDisplayProvider);
		registerView(SamplePlaces.SECOND, secondDisplayProvider);
	}
}
