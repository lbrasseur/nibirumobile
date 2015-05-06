package ar.com.oxen.nibiru.mobile.android.ui.mvp;

import static com.google.common.base.Preconditions.checkNotNull;
import android.text.TextWatcher;
import android.widget.TextView;
import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ChangeHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasValue;

public class TextViewAdapter implements HasValue<String> {
	private final TextView textView;
	private HandlerRegistration changeHandlerRegistration;

	public TextViewAdapter(TextView textView) {
		this.textView = checkNotNull(textView);
	}

	@Override
	public void setValue(String value) {
		textView.setText(value);
	}

	@Override
	public String getValue() {
		return textView.getText().toString();
	}

	@Override
	public HandlerRegistration setChangeHandler(ChangeHandler changeHandler) {
		checkNotNull(changeHandler);
		if (changeHandlerRegistration != null) {
			changeHandlerRegistration.removeHandler();
		}

		final TextWatcher textWatcher = new ChangeHandlerAdapter(changeHandler);
		textView.addTextChangedListener(textWatcher);
		changeHandlerRegistration = new HandlerRegistration() {

			@Override
			public void removeHandler() {
				textView.removeTextChangedListener(textWatcher);
			}
		};

		return changeHandlerRegistration;
	}
}
