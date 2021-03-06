package ar.com.oxen.nibiru.mobile.java.ui.i18n;

import static com.google.common.base.Preconditions.checkNotNull;

import java.lang.reflect.Proxy;

import com.google.inject.Provider;

public class MessageProvider<T> implements Provider<T> {
	private final Class<T> proxyClass;

	public MessageProvider(Class<T> proxyClass) {
		this.proxyClass = checkNotNull(proxyClass);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get() {
		return (T) Proxy.newProxyInstance(proxyClass.getClassLoader(),
				new Class<?>[] { proxyClass }, new MessageInvocationHandler(
						proxyClass));
	}
}
