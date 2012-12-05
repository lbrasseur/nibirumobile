package ar.com.oxen.nibiru.mobile.android.ui.i18n;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ResourceBundle;

public class MessageInvocationHandler implements InvocationHandler {
	private ResourceBundle resourceBundle;

	public MessageInvocationHandler(Class<?> proxyClass) {
		super();
		this.resourceBundle = ResourceBundle.getBundle(proxyClass.getName());
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		String message = this.resourceBundle.getString(method.getName());
		MessageFormat messageFormat = new MessageFormat(message);
		return messageFormat.format(args);
	}
}
