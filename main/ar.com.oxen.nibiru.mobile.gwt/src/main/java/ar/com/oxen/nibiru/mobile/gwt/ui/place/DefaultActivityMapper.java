package ar.com.oxen.nibiru.mobile.gwt.ui.place;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.PresenterActivity;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

public class DefaultActivityMapper implements ActivityMapper {
	private PresenterMapper presenterMapper;

	@Inject
	public DefaultActivityMapper(PresenterMapper presenterMapper) {
		super();
		this.presenterMapper = presenterMapper;
	}

	@Override
	public Activity getActivity(Place place) {
		if (place instanceof SimplePlace) {
			SimplePlace gwtPlace = (SimplePlace) place;
			if (gwtPlace.getId() != null) {
				return new PresenterActivity(
						this.presenterMapper.getPresenter(gwtPlace.getId()),
						gwtPlace);
			}
		}
		return null;
	}
}
