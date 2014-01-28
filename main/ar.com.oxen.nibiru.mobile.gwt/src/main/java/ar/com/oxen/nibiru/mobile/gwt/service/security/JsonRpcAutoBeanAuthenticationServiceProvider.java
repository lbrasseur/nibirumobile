package ar.com.oxen.nibiru.mobile.gwt.service.security;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import ar.com.oxen.nibiru.mobile.core.api.http.HttpManager;
import ar.com.oxen.nibiru.mobile.core.api.service.RemoteService;
import ar.com.oxen.nibiru.mobile.core.impl.service.JsonRpcService;
import ar.com.oxen.nibiru.mobile.gwt.serializer.AutoBeanSerializer;

public class JsonRpcAutoBeanAuthenticationServiceProvider implements
		Provider<RemoteService> {
	private final HttpManager httpManager;
	private final AutoBeanDtoFactory dtoFactory;

	@Inject
	public JsonRpcAutoBeanAuthenticationServiceProvider(
			HttpManager httpManager, AutoBeanDtoFactory dtoFactory) {
		this.httpManager = checkNotNull(httpManager);
		this.dtoFactory = checkNotNull(dtoFactory);
	}

	@Override
	public RemoteService get() {
		return new JsonRpcService("authentication", httpManager,
				new AutoBeanSerializer(dtoFactory));
	}
}
