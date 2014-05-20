package ar.com.oxen.nibiru.mobile.ios.ui.mvp;

import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.cocoatouch.foundation.NSRange;
import org.robovm.cocoatouch.uikit.UITextField;
import org.robovm.cocoatouch.uikit.UITextFieldDelegate;

public class TextFieldDelegate extends NSObject implements UITextFieldDelegate {
	@Override
	public void didBeginEditing(UITextField textField) {
	}

	@Override
	public void didEndEditing(UITextField textField) {
	}

	@Override
	public boolean shouldBeginEditing(UITextField textField) {
		return true;
	}

	@Override
	public boolean shouldChangeCharacters(UITextField textField, NSRange range,
			String text) {
		return true;
	}

	@Override
	public boolean shouldClear(UITextField textField) {
		return true;
	}

	@Override
	public boolean shouldEndEditing(UITextField textField) {
		return true;
	}

	@Override
	public boolean shouldReturn(UITextField textField) {
		return textField.resignFirstResponder();
	}
}