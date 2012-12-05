package ar.com.oxen.nibiru.mobile.smartgwt.ui.mvp;

import com.smartgwt.mobile.client.widgets.ScrollablePanel;
import com.smartgwt.mobile.client.widgets.form.DynamicForm;

public class BaseFormView extends BaseView {
	private DynamicForm form;

	public BaseFormView(String title) {
		super(new ScrollablePanel(title));
		this.form = new DynamicForm();
		this.asNative().addMember(this.form);
	}

	protected DynamicForm getForm() {
		return this.form;
	}
}
