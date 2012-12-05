package ar.com.oxen.nibiru.mobile.android.serializer;

import java.io.IOException;

import javax.inject.Inject;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import ar.com.oxen.nibiru.mobile.core.api.serializer.Serializer;

public class JacksonSerializaer implements Serializer {
	private ObjectMapper mapper;

	@Inject
	public JacksonSerializaer(ObjectMapper mapper) {
		super();
		this.mapper = mapper;
	}

	@Override
	public String serialize(Object object) {
		try {
			return this.mapper.writeValueAsString(object);
		} catch (JsonGenerationException e) {
			throw exception(object, e);
		} catch (JsonMappingException e) {
			throw exception(object, e);
		} catch (IOException e) {
			throw exception(object, e);
		}
	}

	@Override
	public <T> T deserialize(String data, Class<T> returnType) {
		try {
			return this.mapper.readValue(data, returnType);
		} catch (JsonParseException e) {
			throw exception(data, e);
		} catch (JsonMappingException e) {
			throw exception(data, e);
		} catch (IOException e) {
			throw exception(data, e);
		}
	}

	@Override
	public String getEncoding() {
		return "json";
	}

	private RuntimeException exception(Object argument, Exception cause) {
		return new IllegalArgumentException("Invalid object/json:" + argument,
				cause);
	}
}
