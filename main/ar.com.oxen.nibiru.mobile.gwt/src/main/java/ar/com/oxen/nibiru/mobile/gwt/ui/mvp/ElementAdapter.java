package ar.com.oxen.nibiru.mobile.gwt.ui.mvp;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.TakesValue;

import com.google.gwt.dom.client.Element;

public class ElementAdapter implements TakesValue<String> {
	private Element element;

	public ElementAdapter(Element element) {
		super();
		this.element = element;
	}

	@Override
	public void setValue(String value) {
		this.element.setInnerText(value);
	}

	@Override
	public String getValue() {
		return this.element.getInnerText();
	}
}
