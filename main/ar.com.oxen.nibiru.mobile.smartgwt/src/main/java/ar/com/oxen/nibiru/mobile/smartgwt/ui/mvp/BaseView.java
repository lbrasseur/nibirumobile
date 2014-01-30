package ar.com.oxen.nibiru.mobile.smartgwt.ui.mvp;

import static com.google.common.base.Preconditions.checkNotNull;

import com.smartgwt.mobile.client.widgets.Panel;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.View;

public class BaseView implements View {
	private final Panel nativeView;

	public BaseView(Panel nativeView) {
		this.nativeView = checkNotNull(nativeView);
	}

	@Override
	public Panel asNative() {
		return nativeView;
	}
}
