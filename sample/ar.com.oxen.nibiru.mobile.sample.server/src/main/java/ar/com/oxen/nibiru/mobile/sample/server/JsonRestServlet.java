package ar.com.oxen.nibiru.mobile.sample.server;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class JsonRestServlet extends BaseServlet {
	private static final long serialVersionUID = -5998772958053275463L;
	private final Gson gson = new Gson();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			Method method = findMethod(req.getRequestURI().substring(
					req.getRequestURI().lastIndexOf('/') + 1));

			Object result;
			if (method.getParameterTypes().length == 1) {
				result = method.invoke(getService(), gson.fromJson(
						new InputStreamReader(req.getInputStream()),
						method.getParameterTypes()[0]));
			} else {
				result = method.invoke(getService());
			}

			if (result != null) {
				PrintWriter output = new PrintWriter(resp.getOutputStream());
				output.println(gson.toJson(result));
				output.flush();
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private Method findMethod(String methodName) {
		for (Method method : getService().getClass().getMethods()) {
			if (method.getName().equalsIgnoreCase(methodName)
					&& method.getParameterTypes().length <= 1) {
				return method;
			}
		}
		throw new IllegalArgumentException("Method '" + methodName
				+ "' not found");
	}

}
