package ar.com.oxen.nibiru.mobile.android.ui.mvp;

import android.view.View;
import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;

public class ViewAdapter implements HasClickHandler {
	private View view;
	private HandlerRegistration clickHandlerRegistration;

	public ViewAdapter(View view) {
		super();
		this.view = view;
	}

	@Override
	public HandlerRegistration setClickHandler(final ClickHandler clickHandler) {
		if (this.clickHandlerRegistration != null) {
			this.clickHandlerRegistration.removeHandler();
		}
		this.view.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				clickHandler.onClick();
			}
		});
		this.clickHandlerRegistration = new HandlerRegistration() {
			@Override
			public void removeHandler() {
				view.setOnClickListener(null);
			}
		};
		return this.clickHandlerRegistration;
	}
}
