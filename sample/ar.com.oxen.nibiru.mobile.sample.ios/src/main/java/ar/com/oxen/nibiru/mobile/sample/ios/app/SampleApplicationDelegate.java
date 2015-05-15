package ar.com.oxen.nibiru.mobile.sample.ios.app;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;
import org.robovm.apple.uikit.UIApplicationLaunchOptions;

import ar.com.oxen.nibiru.mobile.core.api.app.Bootstrap;
import ar.com.oxen.nibiru.mobile.ios.ioc.DefaultCoreDataModule;
import ar.com.oxen.nibiru.mobile.ios.ioc.DefaultIosHardwareModule;
import ar.com.oxen.nibiru.mobile.ios.ioc.DefaultIosModule;
import ar.com.oxen.nibiru.mobile.java.ioc.DefaultJavaModule;

import com.google.inject.Guice;

public class SampleApplicationDelegate extends UIApplicationDelegateAdapter {
	@Override
    public boolean didFinishLaunching(UIApplication application, 
            UIApplicationLaunchOptions launchOptions) {
		Guice.createInjector(
				new DefaultJavaModule(),
				new DefaultIosModule(),
				new DefaultIosHardwareModule(),
				new DefaultCoreDataModule(),
				new Module())
				.getInstance(Bootstrap.class).onBootstrap();
		return true;
	}

	public static void main(String[] args) {
		NSAutoreleasePool pool = new NSAutoreleasePool();
		UIApplication.main(args, null, SampleApplicationDelegate.class);
		pool.drain();
		pool.close();
	}
}
