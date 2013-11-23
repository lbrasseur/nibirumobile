package ar.com.oxen.nibiru.mobile.ios.ui.place;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import org.robovm.cocoatouch.uikit.UINavigationController;
import org.robovm.cocoatouch.uikit.UIViewController;
import org.robovm.cocoatouch.uikit.UIWindow;

import com.google.common.collect.Maps;

import ar.com.oxen.nibiru.mobile.core.api.common.Identifiable;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.Presenter;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.View;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;
import ar.com.oxen.nibiru.mobile.core.impl.common.AbstractConfigurable;

public class NavigationControllerPlace extends AbstractConfigurable<Place>
		implements Place, Identifiable<String> {
	private final UINavigationController navigationController;
	private final UIWindow mainWindow;
	private final PresenterMapper presenterMapper;
	private final String id;
	private final Map<String, Object> parameters;

	public NavigationControllerPlace(
			UINavigationController navigationController, UIWindow mainWindow,
			PresenterMapper presenterMapper, String id) {
		this.navigationController = checkNotNull(navigationController);
		this.mainWindow = checkNotNull(mainWindow);
		this.presenterMapper = checkNotNull(presenterMapper);
		this.id = checkNotNull(id);
		parameters = Maps.newHashMap();
	}

	@Override
	public String getId() {
		return id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getParameter(String key) {
		checkNotNull(key);
		return (T) parameters.get(key);
	}

	@Override
	public Place addParameter(String key, Object value) {
		checkNotNull(key);
		checkNotNull(value);
		parameters.put(key, value);
		return this;
	}

	@Override
	public void go() {
		this.go(false);
	}

	@Override
	public void go(boolean push) {
		Presenter<? extends View> presenter = presenterMapper.getPresenter(id);
		UIViewController viewController = (UIViewController) presenter
				.getView().asNative();
		if (push) {
			navigationController.pushViewController(viewController, true);
		} else {
			mainWindow.getInputView().removeFromSuperview();
			mainWindow.addSubview(viewController.getView());
		}
		presenter.go(this);
	}
}
