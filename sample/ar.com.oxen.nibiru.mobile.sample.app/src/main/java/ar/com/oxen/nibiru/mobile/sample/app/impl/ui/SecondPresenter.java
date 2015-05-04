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
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SecondPresenter.Display;

public class SecondPresenter extends BasePresenter<Display> {
	public interface Display extends View {
		HasClickHandler getBackTrigger();
	}

	private final PlaceManager placeManager;

	@Inject
	public SecondPresenter(Display view, AlertManager alertManager,
			PlaceManager placeManager) {
		super(view, alertManager);
		this.placeManager = checkNotNull(placeManager);
	}

	@Override
	public void go(Place place) {
		getView().getBackTrigger().setClickHandler(new ClickHandler() {
			@Override
			public void onClick() {
				placeManager.back();
			}
		});
		getAlertManager().showMessage(place.getParameter("message").toString());
	}
}
