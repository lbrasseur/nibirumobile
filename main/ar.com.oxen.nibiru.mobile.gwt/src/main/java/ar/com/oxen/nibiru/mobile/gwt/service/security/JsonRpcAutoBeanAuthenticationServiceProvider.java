package ar.com.oxen.nibiru.mobile.gwt.service.security;

import javax.inject.Inject;
import javax.inject.Provider;

import ar.com.oxen.nibiru.mobile.core.api.http.HttpManager;
import ar.com.oxen.nibiru.mobile.core.api.service.RemoteService;
import ar.com.oxen.nibiru.mobile.core.impl.service.JsonRpcService;
import ar.com.oxen.nibiru.mobile.gwt.serializer.AutoBeanSerializer;

public class JsonRpcAutoBeanAuthenticationServiceProvider implements
		Provider<RemoteService> {
	private HttpManager httpManager;
	private AutoBeanDtoFactory dtoFactory;

	@Inject
	public JsonRpcAutoBeanAuthenticationServiceProvider(
			HttpManager httpManager, AutoBeanDtoFactory dtoFactory) {
		super();
		this.httpManager = httpManager;
		this.dtoFactory = dtoFactory;
	}

	@Override
	public RemoteService get() {
		return new JsonRpcService("authentication", this.httpManager,
				new AutoBeanSerializer(this.dtoFactory));
	}
}
