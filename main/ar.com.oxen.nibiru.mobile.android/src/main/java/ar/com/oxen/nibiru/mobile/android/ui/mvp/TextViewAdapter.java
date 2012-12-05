package ar.com.oxen.nibiru.mobile.android.ui.mvp;

import android.text.TextWatcher;
import android.widget.TextView;
import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.ChangeHandler;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.HasValue;

public class TextViewAdapter implements HasValue<String> {
	private TextView textView;
	private HandlerRegistration changeHandlerRegistration;

	public TextViewAdapter(TextView textView) {
		super();
		this.textView = textView;
	}

	@Override
	public void setValue(String value) {
		this.textView.setText(value);
	}

	@Override
	public String getValue() {
		return this.textView.getText().toString();
	}

	@Override
	public HandlerRegistration setChangeHandler(ChangeHandler changeHandler) {
		if (this.changeHandlerRegistration != null) {
			this.changeHandlerRegistration.removeHandler();
		}

		final TextWatcher textWatcher = new ChangeHandlerAdapter(changeHandler);
		this.textView.addTextChangedListener(textWatcher);
		this.changeHandlerRegistration = new HandlerRegistration() {

			@Override
			public void removeHandler() {
				textView.removeTextChangedListener(textWatcher);
			}
		};

		return this.changeHandlerRegistration;
	}
}
