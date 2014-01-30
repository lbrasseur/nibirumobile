package ar.com.oxen.nibiru.mobile.sample.server;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1058313324775489001L;
	private Object service;

	@Override
	public void init(ServletConfig config) throws ServletException {
		try {
			Class<?> serviceClass = Class.forName(config
					.getInitParameter("serviceClass"));
			service = serviceClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Object getService() {
		return service;
	}

}
