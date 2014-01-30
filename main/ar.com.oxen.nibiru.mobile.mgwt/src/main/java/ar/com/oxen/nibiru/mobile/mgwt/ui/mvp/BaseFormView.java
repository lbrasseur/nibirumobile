package ar.com.oxen.nibiru.mobile.mgwt.ui.mvp;

import ar.com.oxen.nibiru.mobile.gwt.ui.mvp.BaseGwtView;

import com.google.gwt.user.client.ui.Panel;
import com.googlecode.mgwt.ui.client.widget.RoundPanel;
import com.googlecode.mgwt.ui.client.widget.ScrollPanel;

public abstract class BaseFormView extends BaseGwtView {
	private final Panel formPanel;

	public BaseFormView() {
		ScrollPanel scrollPanel = new ScrollPanel();
		initWidget(scrollPanel);

		formPanel = new RoundPanel();
		scrollPanel.add(formPanel);
	}

	protected Panel getFormPanel() {
		return formPanel;
	}
}
