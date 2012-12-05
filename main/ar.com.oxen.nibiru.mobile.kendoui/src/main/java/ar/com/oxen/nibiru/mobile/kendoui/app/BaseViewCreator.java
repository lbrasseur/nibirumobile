package ar.com.oxen.nibiru.mobile.kendoui.app;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Provider;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.View;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class BaseViewCreator implements ViewCreator {
	private Map<String, Provider<? extends View>> viewProviders = new HashMap<String, Provider<? extends View>>();

	protected void registerView(String place,
			Provider<? extends View> viewProvider) {
		this.viewProviders.put(place, viewProvider);
	}

	protected void registerView(Enum<?> place,
			Provider<? extends View> viewProvider) {
		this.registerView(place.toString(), viewProvider);
	}

	@Override
	public void createViews() {
		for (Map.Entry<String, Provider<? extends View>> entry : this.viewProviders
				.entrySet()) {
			addView(entry.getKey(), entry.getValue().get());

		}
		startKendo();
	}

	private void addView(String id, View view) {
		FlowPanel div = new FlowPanel();
		div.getElement().setId(id);
		div.getElement().setAttribute("data-role", "view");
		RootPanel.get().add(div);
		div.add((Widget) view.asNative());
	}

	private native void startKendo() /*-{
		$wnd.kendoMobileApplication = new $wnd.kendo.mobile.Application($doc.body);
	}-*/;
}
