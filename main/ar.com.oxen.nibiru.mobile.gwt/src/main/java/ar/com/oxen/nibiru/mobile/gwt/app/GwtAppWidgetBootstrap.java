package ar.com.oxen.nibiru.mobile.gwt.app;

import javax.inject.Inject;


import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;

public class GwtAppWidgetBootstrap implements AppWidgetBootstrap {
	private EventBus eventBus;
	private ActivityMapper activityMapper;

	@Inject
	public GwtAppWidgetBootstrap(EventBus eventBus, ActivityMapper activityMapper) {
		super();
		this.eventBus = eventBus;
		this.activityMapper = activityMapper;
	}

	@Override
	public IsWidget createAppWidget() {
		SimplePanel appWidget = new SimplePanel();

		ActivityManager activityManager = new ActivityManager(
				this.activityMapper, this.eventBus);
		activityManager.setDisplay(appWidget);

		return appWidget;
	}
}
