package ar.com.oxen.nibiru.mobile.android.ioc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import javax.inject.Inject;
import javax.inject.Provider;

public class ProxyProvider<T, I extends InvocationHandler> implements
		Provider<T> {
	private Class<T> proxyInterface;
	private I handler;

	@Inject
	public ProxyProvider(Class<T> proxyInterface, I handler) {
		super();
		this.proxyInterface = proxyInterface;
		this.handler = handler;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get() {
		return (T) Proxy.newProxyInstance(getClass().getClassLoader(),
				new Class<?>[] { proxyInterface }, this.handler);
	}
}
