package ar.com.oxen.nibiru.mobile.gwt.ui.mvp;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.Presenter;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.View;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Presenter-based activity.
 */
public class PresenterActivity extends AbstractActivity {
	private Presenter<? extends View> presenter;
	private Place place;

	public PresenterActivity(Presenter<? extends View> presenter, Place place) {
		super();
		this.presenter = presenter;
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		IsWidget widget = (IsWidget) this.presenter.getView().asNative();
		containerWidget.setWidget(widget);
		this.presenter.go(this.place);
	}

	@Override
	public void onStop() {
		super.onStop();
		this.presenter.onStop();
	}
}
