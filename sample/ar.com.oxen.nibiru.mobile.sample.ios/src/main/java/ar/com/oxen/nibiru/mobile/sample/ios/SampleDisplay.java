package ar.com.oxen.nibiru.mobile.sample.ios;

import org.robovm.cocoatouch.uikit.UIViewController;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.TakesValue;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SamplePresenter.Display;

public class SampleDisplay extends UIViewController implements Display {
	@Override
	public void loadView() {
		// TODO Auto-generated method stub
		super.loadView();
	}

	@Override
	public HasClickHandler getAlertTrigger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasClickHandler getGreetingTrigger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TakesValue<String> getNameLoad() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TakesValue<String> getGreetingDisplay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasClickHandler getBackTrigger() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HasClickHandler getShowLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object asNative() {
		return this;
	}
}
