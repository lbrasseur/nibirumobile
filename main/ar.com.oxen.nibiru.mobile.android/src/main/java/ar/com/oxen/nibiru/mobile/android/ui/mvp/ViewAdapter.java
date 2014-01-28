package ar.com.oxen.nibiru.mobile.android.ui.mvp;

import static com.google.common.base.Preconditions.checkNotNull;
import android.view.View;
import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ClickHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasClickHandler;

public class ViewAdapter implements HasClickHandler {
	private final View view;
	private HandlerRegistration clickHandlerRegistration;

	public ViewAdapter(View view) {
		this.view = checkNotNull(view);
	}

	@Override
	public HandlerRegistration setClickHandler(final ClickHandler clickHandler) {
		checkNotNull(clickHandler);
		if (clickHandlerRegistration != null) {
			clickHandlerRegistration.removeHandler();
		}
		view.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View view) {
				clickHandler.onClick();
			}
		});
		clickHandlerRegistration = new HandlerRegistration() {
			@Override
			public void removeHandler() {
				view.setOnClickListener(null);
			}
		};
		return clickHandlerRegistration;
	}
}
