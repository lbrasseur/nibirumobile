package ar.com.oxen.nibiru.mobile.mgwt.ui.mvp;

import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.BaseGwtView;

import com.google.gwt.user.client.ui.HasWidgets;
import com.googlecode.mgwt.ui.client.widget.form.Form;
import com.googlecode.mgwt.ui.client.widget.panel.scroll.ScrollPanel;

public abstract class BaseFormView extends BaseGwtView {
	private final Form formPanel;

	public BaseFormView() {
		ScrollPanel scrollPanel = new ScrollPanel();
		initWidget(scrollPanel);

		formPanel = new Form();
		scrollPanel.add(formPanel);
	}

	protected HasWidgets getFormPanel() {
		return formPanel;
	}
}
