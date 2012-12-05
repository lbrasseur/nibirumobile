package ar.com.oxen.nibiru.mobile.gwt.ui.place;

import java.util.HashMap;
import java.util.Map;

import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;

import com.google.gwt.http.client.URL;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceTokenizer;

public class SimplePlace extends com.google.gwt.place.shared.Place implements
		Place {
	private String id;
	private PlaceController placeController;
	private Map<String, Object> parameters;
	private int order;

	public SimplePlace(String id, int order, PlaceController placeController) {
		super();
		this.id = id;
		this.placeController = placeController;
		this.parameters = new HashMap<String, Object>();
		this.order = order;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getParameter(String key) {
		return (T) this.parameters.get(key);
	}

	@Override
	public <T> T getParameter(Enum<?> key) {
		return this.getParameter(key.toString());
	}

	@Override
	public Place addParameter(String key, Object value) {
		this.parameters.put(key, value);
		return this;
	}

	@Override
	public Place addParameter(Enum<?> key, Object value) {
		return this.addParameter(key.toString(), value);
	}

	@Override
	public void go(boolean push) {
		this.placeController.goTo(this);
	}

	@Override
	public void go() {
		this.go(false);
	}

	public static class Tokenizer implements PlaceTokenizer<SimplePlace> {
		// TODO: No entiendo bien como es el tema de la tokenizacion. Por
		// ejemplo, no le estoy pasando los parametros, pero sin embargo
		// funciona igual...

		@Override
		public String getToken(SimplePlace place) {
			StringBuilder sb = new StringBuilder();

			sb.append(place.getId());
			sb.append("/");
			sb.append(place.order);

			boolean first = true;
			for (Map.Entry<String, Object> entry : place.parameters.entrySet()) {
				// TODO por ahora, solo String en la URL
				if (entry.getValue() instanceof String) {
					if (first) {
						sb.append("/");
					} else {
						sb.append("&");
					}
					sb.append(entry.getKey());
					sb.append("=");
					sb.append(URL.encode(entry.getValue().toString()));
				}
			}

			return sb.toString();
		}

		@Override
		public SimplePlace getPlace(String token) {
			String[] tokens = token.split("/");
			SimplePlace place = new SimplePlace(tokens[0],
					Integer.valueOf(tokens[1]), null);

			if (tokens.length > 2) {
				for (String argToken : tokens[2].split("&")) {
					String[] arg = argToken.split("=");
					place.addParameter(arg[0], URL.decode(arg[1]));
				}
			}

			return place;
		}
	}

	public boolean forwardFrom(SimplePlace other) {
		return order > other.order;
	}
}
