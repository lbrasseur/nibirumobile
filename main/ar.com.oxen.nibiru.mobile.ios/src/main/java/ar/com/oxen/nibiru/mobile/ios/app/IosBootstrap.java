package ar.com.oxen.nibiru.mobile.ios.app;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import org.robovm.cocoatouch.uikit.UIColor;
import org.robovm.cocoatouch.uikit.UINavigationController;
import org.robovm.cocoatouch.uikit.UIWindow;

import ar.com.oxen.nibiru.mobile.core.api.app.Bootstrap;
import ar.com.oxen.nibiru.mobile.core.api.app.EntryPoint;

public class IosBootstrap implements Bootstrap {
	private final EntryPoint entryPoint;
	private final UIWindow mainWindow;
	private final Provider<UINavigationController> navigationControllerProvider;

	@Inject
	public IosBootstrap(EntryPoint entryPoint, UIWindow mainWindow,
			Provider<UINavigationController> navigationControllerProvider) {
		this.entryPoint = checkNotNull(entryPoint);
		this.mainWindow = checkNotNull(mainWindow);
		this.navigationControllerProvider = checkNotNull(navigationControllerProvider);
	}

	@Override
	public void onBootstrap() {
		// TODO: Background color should be application-specific?
		mainWindow.setBackgroundColor(UIColor.lightGrayColor());
		mainWindow.makeKeyAndVisible();
		UINavigationController navigationController = navigationControllerProvider
				.get();
		mainWindow.setRootViewController(navigationController);
		mainWindow.addSubview(navigationController.getView());
		entryPoint.onApplicationStart();
	}
}
