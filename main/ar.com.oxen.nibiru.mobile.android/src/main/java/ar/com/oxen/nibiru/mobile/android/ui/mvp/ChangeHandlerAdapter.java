package ar.com.oxen.nibiru.mobile.android.ui.mvp;

import static com.google.common.base.Preconditions.checkNotNull;
import android.text.Editable;
import android.text.TextWatcher;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ChangeHandler;

public class ChangeHandlerAdapter implements TextWatcher {
	private final ChangeHandler changeHandler;

	public ChangeHandlerAdapter(ChangeHandler changeHandler) {
		this.changeHandler = checkNotNull(changeHandler);
	}

	@Override
	public void afterTextChanged(Editable s) {
		changeHandler.onChange();
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
	}
}
