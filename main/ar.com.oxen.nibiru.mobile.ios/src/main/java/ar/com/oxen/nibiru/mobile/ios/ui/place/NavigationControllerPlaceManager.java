package ar.com.oxen.nibiru.mobile.ios.ui.place;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import org.robovm.cocoatouch.uikit.UINavigationController;
import org.robovm.cocoatouch.uikit.UIWindow;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;

public class NavigationControllerPlaceManager implements PlaceManager {
	private final UINavigationController navigationController;
	private final UIWindow mainWindow;
	private final PresenterMapper presenterMapper;

	@Inject
	public NavigationControllerPlaceManager(
			UINavigationController navigationController, UIWindow mainWindow,
			PresenterMapper presenterMapper) {
		this.navigationController = checkNotNull(navigationController);
		this.mainWindow = checkNotNull(mainWindow);
		this.presenterMapper = checkNotNull(presenterMapper);
	}

	@Override
	public Place createPlace(String id) {
		return new NavigationControllerPlace(navigationController, mainWindow,
				presenterMapper, id);
	}

	@Override
	public Place createPlace(Enum<?> id) {
		return createPlace(id.toString());
	}

	@Override
	public void back() {
		navigationController.popViewControllerAnimated(true);
	}
}
