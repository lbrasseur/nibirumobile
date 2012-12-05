package ar.com.oxen.nibiru.mobile.gwt.ui.mvp;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.TakesValue;

import com.google.gwt.user.client.ui.Label;

public class LabelAdapter implements TakesValue<String> {
	private Label label;

	public LabelAdapter(Label label) {
		super();
		this.label = label;
	}

	@Override
	public void setValue(String value) {
		this.label.setText(value);
	}

	@Override
	public String getValue() {
		return this.label.getText();
	}
}
