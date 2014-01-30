package ar.com.oxen.nibiru.mobile.mgwt.ui.mvp;

import static com.google.common.base.Preconditions.checkNotNull;
import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.gwt.handler.HandlerRegistrationAdapter;

import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

public class HasTapHandlersAdapter implements HasClickHandler {
	private final HasTapHandlers hasClickHandlers;
	private HandlerRegistration tapHandlerRegistration;

	public HasTapHandlersAdapter(HasTapHandlers hasTapHandlers) {
		this.hasClickHandlers = checkNotNull(hasTapHandlers);
	}

	@Override
	public HandlerRegistration setClickHandler(final ClickHandler clickHandler) {
		if (tapHandlerRegistration != null) {
			tapHandlerRegistration.removeHandler();
		}

		tapHandlerRegistration = new HandlerRegistrationAdapter(
				hasClickHandlers.addTapHandler(new TapHandler() {
					@Override
					public void onTap(TapEvent event) {
						clickHandler.onClick();
					}
				}));

		return tapHandlerRegistration;
	}
}
