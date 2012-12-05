package ar.com.oxen.nibiru.mobile.mgwt.ui.mvp;

import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.gwt.handler.HandlerRegistrationAdapter;

import com.googlecode.mgwt.dom.client.event.tap.HasTapHandlers;
import com.googlecode.mgwt.dom.client.event.tap.TapEvent;
import com.googlecode.mgwt.dom.client.event.tap.TapHandler;

public class HasTapHandlersAdapter implements HasClickHandler {
	private HasTapHandlers hasClickHandlers;
	private HandlerRegistration tapHandlerRegistration;

	public HasTapHandlersAdapter(HasTapHandlers hasTapHandlers) {
		super();
		this.hasClickHandlers = hasTapHandlers;
	}

	@Override
	public HandlerRegistration setClickHandler(final ClickHandler clickHandler) {
		if (this.tapHandlerRegistration != null) {
			this.tapHandlerRegistration.removeHandler();
		}

		this.tapHandlerRegistration = new HandlerRegistrationAdapter(
				this.hasClickHandlers.addTapHandler(new TapHandler() {
					@Override
					public void onTap(TapEvent event) {
						clickHandler.onClick();
					}
				}));

		return this.tapHandlerRegistration;
	}

}
