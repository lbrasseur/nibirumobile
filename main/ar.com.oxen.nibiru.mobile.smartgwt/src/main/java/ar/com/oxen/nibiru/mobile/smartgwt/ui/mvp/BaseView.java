package ar.com.oxen.nibiru.mobile.smartgwt.ui.mvp;

import com.smartgwt.mobile.client.widgets.Panel;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.View;

public class BaseView implements View {
	private Panel nativeView;

	public BaseView(Panel nativeView) {
		super();
		this.nativeView = nativeView;
	}

	@Override
	public Panel asNative() {
		return this.nativeView;
	}
}
