package ar.com.oxen.nibiru.mobile.ios.app;

import javax.inject.Inject;

import org.robovm.cocoatouch.uikit.UIColor;
import org.robovm.cocoatouch.uikit.UIWindow;

import static com.google.common.base.Preconditions.checkNotNull;
import ar.com.oxen.nibiru.mobile.core.api.app.Bootstrap;
import ar.com.oxen.nibiru.mobile.core.api.app.EntryPoint;

public class IosBootstrap implements Bootstrap {
	private final EntryPoint entryPoint;
	private final UIWindow mainWindow;

	@Inject
	public IosBootstrap(EntryPoint entryPoint, UIWindow mainWindow) {
		this.entryPoint = checkNotNull(entryPoint);
		this.mainWindow = checkNotNull(mainWindow);
	}

	@Override
	public void onBootstrap() {
		mainWindow.setBackgroundColor(UIColor.lightGrayColor());
		mainWindow.makeKeyAndVisible();
		entryPoint.onApplicationStart();
	}
}
