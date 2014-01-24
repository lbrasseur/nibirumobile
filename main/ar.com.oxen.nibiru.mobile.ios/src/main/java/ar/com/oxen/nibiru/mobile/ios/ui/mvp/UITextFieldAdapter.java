package ar.com.oxen.nibiru.mobile.ios.ui.mvp;

import static com.google.common.base.Preconditions.checkNotNull;

import org.robovm.cocoatouch.uikit.UITextField;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.TakesValue;

import com.google.common.base.Strings;

public class UITextFieldAdapter implements TakesValue<String> {
	private final UITextField textField;

	public UITextFieldAdapter(UITextField textField) {
		this.textField = checkNotNull(textField);
	}

	@Override
	public void setValue(String value) {
		textField.setText(value);
	}

	@Override
	public String getValue() {
		return Strings.nullToEmpty(textField.getText());
	}
}
