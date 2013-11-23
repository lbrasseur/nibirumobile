package ar.com.oxen.nibiru.mobile.sample.ios;

import org.robovm.cocoatouch.foundation.NSAutoreleasePool;
import org.robovm.cocoatouch.foundation.NSDictionary;
import org.robovm.cocoatouch.uikit.UIApplication;
import org.robovm.cocoatouch.uikit.UIApplicationDelegate;

import ar.com.oxen.nibiru.mobile.core.api.app.Bootstrap;
import ar.com.oxen.nibiru.mobile.ios.ioc.DefaultIosModule;

import com.google.inject.Guice;

public class SampleApplicationDelegate extends UIApplicationDelegate.Adapter {
	@SuppressWarnings("rawtypes")
	@Override
	public boolean didFinishLaunching(UIApplication application,
			NSDictionary launchOptions) {
		Guice.createInjector(
				new DefaultIosModule(),
				new Module())
				.getInstance(Bootstrap.class).onBootstrap();
		return true;
	}

	public static void main(String[] args) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(args, null, SampleApplicationDelegate.class);
		pool.drain();
	}
}
