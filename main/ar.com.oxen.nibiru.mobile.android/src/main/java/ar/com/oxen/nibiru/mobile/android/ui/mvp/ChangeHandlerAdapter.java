package ar.com.oxen.nibiru.mobile.android.ui.mvp;

import android.text.Editable;
import android.text.TextWatcher;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ChangeHandler;

public class ChangeHandlerAdapter implements TextWatcher {
	private ChangeHandler changeHandler;

	public ChangeHandlerAdapter(ChangeHandler changeHandler) {
		super();
		this.changeHandler = changeHandler;
	}

	@Override
	public void afterTextChanged(Editable s) {
		this.changeHandler.onChange();
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
	}
}
