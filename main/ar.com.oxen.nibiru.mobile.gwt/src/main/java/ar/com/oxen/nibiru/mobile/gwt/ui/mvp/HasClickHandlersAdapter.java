package ar.com.oxen.nibiru.mobile.gwt.ui.mvp;

import static com.google.common.base.Preconditions.checkNotNull;
import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;
import ar.com.oxen.nibiru.mobile.gwt.handler.HandlerRegistrationAdapter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;

public class HasClickHandlersAdapter implements HasClickHandler {
	private final HasClickHandlers hasClickHandlers;
	private HandlerRegistration clickHandlerRegistration;

	public HasClickHandlersAdapter(HasClickHandlers hasClickHandlers) {
		this.hasClickHandlers = checkNotNull(hasClickHandlers);
	}

	@Override
	public HandlerRegistration setClickHandler(final ClickHandler clickHandler) {
		checkNotNull(clickHandler);
		if (clickHandlerRegistration != null) {
			clickHandlerRegistration.removeHandler();
		}

		clickHandlerRegistration = new HandlerRegistrationAdapter(
				hasClickHandlers
						.addClickHandler(new com.google.gwt.event.dom.client.ClickHandler() {
							@Override
							public void onClick(ClickEvent event) {
								clickHandler.onClick();

							}
						}));

		return clickHandlerRegistration;
	}
}
