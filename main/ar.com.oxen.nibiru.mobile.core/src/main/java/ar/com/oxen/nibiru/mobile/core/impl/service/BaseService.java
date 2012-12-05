package ar.com.oxen.nibiru.mobile.core.impl.service;

import ar.com.oxen.nibiru.mobile.core.api.http.HttpManager;
import ar.com.oxen.nibiru.mobile.core.api.serializer.Serializer;
import ar.com.oxen.nibiru.mobile.core.api.service.RemoteService;

abstract class BaseService implements RemoteService {
	private String serviceName;
	private HttpManager httpManager;
	private Serializer serializer;

	public BaseService(String serviceName, HttpManager httpManager,
			Serializer serializer) {
		super();
		this.serviceName = serviceName;
		this.httpManager = httpManager;
		this.serializer = serializer;
	}

	protected String getServiceName() {
		return serviceName;
	}

	protected HttpManager getHttpManager() {
		return httpManager;
	}

	protected Serializer getSerializer() {
		return serializer;
	}
}
