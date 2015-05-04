package ar.com.oxen.nibiru.mobile.sample.app.impl.ui;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.View;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;
import ar.com.oxen.nibiru.mobile.core.impl.mvp.BasePresenter;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.MainMenuPresenter.Display;

public class MainMenuPresenter extends BasePresenter<Display> {
	public interface Display extends View {
		HasClickHandler getCustomerManagement();

		HasClickHandler getSamples();
	}

	private final PlaceManager placeManager;

	@Inject
	public MainMenuPresenter(Display view, AlertManager alertManager,
			PlaceManager placeManager) {
		super(view, alertManager);
		this.placeManager = checkNotNull(placeManager);
	}

	@Override
	public void go(Place place) {
		getView().getCustomerManagement().setClickHandler(new ClickHandler() {
			@Override
			public void onClick() {
				placeManager.createPlace(Places.CUSTOMER_MANAGEMENT).go(true);
			}
		});

		getView().getSamples().setClickHandler(new ClickHandler() {
			@Override
			public void onClick() {
				placeManager.createPlace(Places.SAMPLES).go(true);
			}
		});
	}
}
