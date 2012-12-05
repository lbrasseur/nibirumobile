package ar.com.oxen.nibiru.mobile.gwt.ui.mvp;

import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.gwt.handler.HandlerRegistrationAdapter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;

public class HasClickHandlersAdapter implements HasClickHandler {
	private HasClickHandlers hasClickHandlers;
	private HandlerRegistration clickHandlerRegistration;

	public HasClickHandlersAdapter(HasClickHandlers hasClickHandlers) {
		super();
		this.hasClickHandlers = hasClickHandlers;
	}

	@Override
	public HandlerRegistration setClickHandler(final ClickHandler clickHandler) {
		if (this.clickHandlerRegistration != null) {
			this.clickHandlerRegistration.removeHandler();
		}

		this.clickHandlerRegistration = new HandlerRegistrationAdapter(
				this.hasClickHandlers
						.addClickHandler(new com.google.gwt.event.dom.client.ClickHandler() {
							@Override
							public void onClick(ClickEvent event) {
								clickHandler.onClick();

							}
						}));

		return this.clickHandlerRegistration;
	}

}
