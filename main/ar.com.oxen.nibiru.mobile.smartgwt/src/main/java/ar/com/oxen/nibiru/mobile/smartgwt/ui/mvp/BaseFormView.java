package ar.com.oxen.nibiru.mobile.smartgwt.ui.mvp;

import static com.google.common.base.Preconditions.checkNotNull;

import com.smartgwt.mobile.client.widgets.ScrollablePanel;
import com.smartgwt.mobile.client.widgets.form.DynamicForm;

public class BaseFormView extends BaseView {
	private final DynamicForm form;

	public BaseFormView(String title) {
		super(new ScrollablePanel(checkNotNull(title)));
		form = new DynamicForm();
		asNative().addMember(form);
	}

	protected DynamicForm getForm() {
		return form;
	}
}
