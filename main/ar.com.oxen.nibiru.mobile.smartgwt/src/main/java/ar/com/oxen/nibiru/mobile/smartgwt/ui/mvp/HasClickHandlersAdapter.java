package ar.com.oxen.nibiru.mobile.smartgwt.ui.mvp;

import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.gwt.handler.HandlerRegistrationAdapter;

import com.smartgwt.mobile.client.widgets.events.ClickEvent;
import com.smartgwt.mobile.client.widgets.events.HasClickHandlers;

public class HasClickHandlersAdapter implements HasClickHandler {
	private HasClickHandlers hasClickHandlers;

	public HasClickHandlersAdapter(HasClickHandlers hasClickHandlers) {
		super();
		this.hasClickHandlers = hasClickHandlers;
	}

	@Override
	public HandlerRegistration setClickHandler(final ClickHandler clickHandler) {
		return new HandlerRegistrationAdapter(
				this.hasClickHandlers
						.addClickHandler(new com.smartgwt.mobile.client.widgets.events.ClickHandler() {
							@Override
							public void onClick(ClickEvent event) {
								clickHandler.onClick();
							}
						}));
	}
}
