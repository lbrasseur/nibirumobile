package ar.com.oxen.nibiru.mobile.sample.kendoui.client;

import javax.inject.Inject;
import javax.inject.Provider;

import ar.com.oxen.nibiru.mobile.core.api.ui.place.DefaultPlaces;
import ar.com.oxen.nibiru.mobile.core.impl.ui.security.LoginPresenter.Display;
import ar.com.oxen.nibiru.mobile.kendoui.app.BaseViewCreator;

public class SampleViewCreator extends BaseViewCreator {
	@Inject
	public SampleViewCreator(
			Provider<Display> loginDisplayProvider,
			Provider<ar.com.oxen.nibiru.mobile.sample.app.ui.SamplePresenter.Display> sampleDisplayProvider) {
		super();
		this.registerView(DefaultPlaces.LOGIN, loginDisplayProvider);
		this.registerView(DefaultPlaces.HOME, sampleDisplayProvider);
	}
}
