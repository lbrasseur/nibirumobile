package ar.com.oxen.nibiru.mobile.gwt.ui.mvp;

import static com.google.common.base.Preconditions.checkNotNull;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.TakesValue;

import com.google.gwt.user.client.ui.Label;

public class LabelAdapter implements TakesValue<String> {
	private final Label label;

	public LabelAdapter(Label label) {
		this.label = checkNotNull(label);
	}

	@Override
	public void setValue(String value) {
		checkNotNull(value);
		label.setText(value);
	}

	@Override
	public String getValue() {
		return label.getText();
	}
}
