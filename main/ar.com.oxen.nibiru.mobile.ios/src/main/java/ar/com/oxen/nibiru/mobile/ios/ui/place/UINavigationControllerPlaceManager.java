package ar.com.oxen.nibiru.mobile.ios.ui.place;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import org.robovm.cocoatouch.uikit.UINavigationController;
import org.robovm.cocoatouch.uikit.UIWindow;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;

public class UINavigationControllerPlaceManager implements PlaceManager {
	private final UIWindow mainWindow;
	private final Provider<UINavigationController> navigationControllerProvider;
	private final PresenterMapper presenterMapper;

	@Inject
	public UINavigationControllerPlaceManager(
			UIWindow mainWindow,
			Provider<UINavigationController> navigationControllerProvider,
			PresenterMapper presenterMapper) {
		this.mainWindow = checkNotNull(mainWindow);
		this.navigationControllerProvider = checkNotNull(navigationControllerProvider);
		this.presenterMapper = checkNotNull(presenterMapper);
	}

	@Override
	public Place createPlace(String id) {
		return new UINavigationControllerPlace(mainWindow,
				navigationControllerProvider, presenterMapper, id);
	}

	@Override
	public Place createPlace(Enum<?> id) {
		return createPlace(id.toString());
	}

	@Override
	public void back() {
		UINavigationController navigationController = (UINavigationController) mainWindow.getRootViewController();
		navigationController.popViewControllerAnimated(true);
	}
}
