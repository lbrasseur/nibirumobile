package ar.com.oxen.nibiru.mobile.android.ui.mvp;

import android.view.View;
import android.widget.AdapterView;
import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ChangeHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasChangeHandler;

public class AdapterViewAdapter implements HasChangeHandler {
	private AdapterView<?> view;
	private HandlerRegistration changeHandlerRegistration;

	public AdapterViewAdapter(AdapterView<?> view) {
		super();
		this.view = view;
	}

	@Override
	public HandlerRegistration setChangeHandler(final ChangeHandler changeHandler) {
		if (this.changeHandlerRegistration!=null) {
			this.changeHandlerRegistration.removeHandler();
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
		
		this.changeHandlerRegistration = new HandlerRegistration() {
			
			@Override
			public void removeHandler() {
				view.setOnItemSelectedListener(null);
			}
		};
		
		return this.changeHandlerRegistration;
	}
}
