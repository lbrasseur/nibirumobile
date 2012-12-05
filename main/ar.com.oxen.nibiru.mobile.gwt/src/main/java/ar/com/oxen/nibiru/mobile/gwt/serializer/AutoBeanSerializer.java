package ar.com.oxen.nibiru.mobile.gwt.serializer;

import ar.com.oxen.nibiru.mobile.core.api.serializer.Serializer;

import com.google.web.bindery.autobean.shared.AutoBeanCodex;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.google.web.bindery.autobean.shared.AutoBeanUtils;

public class AutoBeanSerializer implements Serializer {
	private AutoBeanFactory autoBeanFactory;

	public AutoBeanSerializer(AutoBeanFactory autoBeanFactory) {
		super();
		this.autoBeanFactory = autoBeanFactory;
	}

	@Override
	public String serialize(Object object) {
		return AutoBeanCodex.encode(AutoBeanUtils.getAutoBean(object))
				.getPayload();
	}

	@Override
	public <T> T deserialize(String data, Class<T> returnType) {
		if (data != null && !data.trim().equalsIgnoreCase("null")) {
			return AutoBeanCodex.decode(this.autoBeanFactory, returnType, data)
					.as();
		} else {
			return null;
		}
	}

	@Override
	public String getEncoding() {
		return "json";
	}
}
