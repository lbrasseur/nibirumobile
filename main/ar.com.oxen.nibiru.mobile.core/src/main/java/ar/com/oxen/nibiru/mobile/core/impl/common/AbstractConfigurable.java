package ar.com.oxen.nibiru.mobile.core.impl.common;

import ar.com.oxen.nibiru.mobile.core.api.common.Configurable;

public abstract class AbstractConfigurable<C> implements Configurable<C> {
	@Override
	public <T> T getParameter(Enum<?> key) {
		return this.getParameter(key.toString());
	}

	@Override
	public C addParameter(Enum<?> key, Object value) {
		return this.addParameter(key.toString(), value);
	}
}
