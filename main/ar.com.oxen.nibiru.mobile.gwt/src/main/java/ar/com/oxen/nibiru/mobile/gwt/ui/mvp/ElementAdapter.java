package ar.com.oxen.nibiru.mobile.gwt.ui.mvp;

import static com.google.common.base.Preconditions.checkNotNull;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.TakesValue;

import com.google.gwt.dom.client.Element;

public class ElementAdapter implements TakesValue<String> {
	private final Element element;

	public ElementAdapter(Element element) {
		this.element = checkNotNull(element);
	}

	@Override
	public void setValue(String value) {
		checkNotNull(value);
		element.setInnerText(value);
	}

	@Override
	public String getValue() {
		return element.getInnerText();
	}
}
