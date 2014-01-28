package ar.com.oxen.nibiru.mobile.android.ui.mvp;

import static com.google.common.base.Preconditions.checkNotNull;
import android.view.View;
import android.widget.AdapterView;
import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ChangeHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasChangeHandler;

public class AdapterViewAdapter implements HasChangeHandler {
	private final AdapterView<?> view;
	private HandlerRegistration changeHandlerRegistration;

	public AdapterViewAdapter(AdapterView<?> view) {
		this.view = checkNotNull(view);
	}

	@Override
	public HandlerRegistration setChangeHandler(final ChangeHandler changeHandler) {
		checkNotNull(changeHandler);
		if (changeHandlerRegistration!=null) {
			changeHandlerRegistration.removeHandler();
		}
		
		AdapterView.OnItemSelectedListener listener =new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				changeHandler.onChange();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		};
		view.setOnItemSelectedListener(listener);
		
		changeHandlerRegistration = new HandlerRegistration() {
			
			@Override
			public void removeHandler() {
				view.setOnItemSelectedListener(null);
			}
		};
		
		return changeHandlerRegistration;
	}
}
