package ar.com.oxen.nibiru.mobile.mgwt.app;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.gwt.app.AppWidgetBootstrap;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.mgwt.mvp.client.AnimatableDisplay;
import com.googlecode.mgwt.mvp.client.AnimatingActivityManager;
import com.googlecode.mgwt.mvp.client.AnimationMapper;

public class MgwtAppWidgetBootstrap implements AppWidgetBootstrap {
	private EventBus eventBus;
	private ActivityMapper activityMapper;
	private AnimationMapper animationMapper;

	@Inject
	public MgwtAppWidgetBootstrap(EventBus eventBus,
			ActivityMapper activityMapper, AnimationMapper animationMapper) {
		super();
		this.eventBus = eventBus;
		this.activityMapper = activityMapper;
		this.animationMapper = animationMapper;
	}

	@Override
	public IsWidget createAppWidget() {
		AnimatableDisplay appWidget = GWT.create(AnimatableDisplay.class);

		AnimatingActivityManager activityManager = new AnimatingActivityManager(
				this.activityMapper, this.animationMapper, this.eventBus);
		activityManager.setDisplay(appWidget);

		return appWidget;
	}
}
