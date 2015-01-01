package ar.com.oxen.nibiru.mobile.ios.ui.mvp;

import org.robovm.apple.uikit.UITextFieldDelegate;

public abstract class BaseUIViewView implements UIViewView {
	private final UITextFieldDelegate textFieldDelegate = new TextFieldDelegate();

	protected UITextFieldDelegate getTextFieldDelegate() {
		return textFieldDelegate;
	}
}
