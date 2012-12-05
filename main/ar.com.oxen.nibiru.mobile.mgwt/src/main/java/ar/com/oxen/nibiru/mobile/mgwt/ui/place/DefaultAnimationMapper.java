package ar.com.oxen.nibiru.mobile.mgwt.ui.place;

import ar.com.oxen.nibiru.mobile.gwt.ui.place.SimplePlace;

import com.google.gwt.place.shared.Place;
import com.googlecode.mgwt.mvp.client.Animation;
import com.googlecode.mgwt.mvp.client.AnimationMapper;

public class DefaultAnimationMapper implements AnimationMapper {

	@Override
	public Animation getAnimation(Place oldPlace, Place newPlace) {
		int anim = (int) (Math.random() * 6);

		boolean forward = true;
		if (oldPlace instanceof SimplePlace && newPlace instanceof SimplePlace) {
			forward = ((SimplePlace) newPlace)
					.forwardFrom((SimplePlace) oldPlace);
		}

		if (forward) {
			switch (anim) {
			case 0:
				return Animation.SLIDE;
			case 1:
				return Animation.FLIP;
			case 2:
				return Animation.DISSOLVE;
			case 3:
				return Animation.POP;
			case 4:
				return Animation.SWAP;
			case 5:
				return Animation.FADE;
			default:
				return Animation.SLIDE;
			}
		} else {
			switch (anim) {
			case 0:
				return Animation.SLIDE_REVERSE;
			case 1:
				return Animation.FLIP_REVERSE;
			case 2:
				return Animation.DISSOLVE_REVERSE;
			case 3:
				return Animation.POP_REVERSE;
			case 4:
				return Animation.SWAP_REVERSE;
			case 5:
				return Animation.FADE_REVERSE;
			default:
				return Animation.SLIDE_UP_REVERSE;
			}
		}
	}

}
