package ar.com.oxen.nibiru.mobile.android.ioc;

import java.lang.reflect.Proxy;

import ar.com.oxen.nibiru.mobile.android.ui.i18n.MessageInvocationHandler;

import com.google.inject.Provider;

public class MessageProvider<T> implements Provider<T> {
	private Class<T> proxyClass;

	public MessageProvider(Class<T> proxyClass) {
		super();
		this.proxyClass = proxyClass;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get() {
		return (T) Proxy.newProxyInstance(this.proxyClass.getClassLoader(),
				new Class<?>[] { this.proxyClass },
				new MessageInvocationHandler(this.proxyClass));
	}

}
