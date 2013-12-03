package ar.com.oxen.nibiru.mobile.sample.ios;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.core.api.service.RemoteService;

public class DummyRemoteService implements RemoteService {

	@Override
	public <T> void invoke(String method, Object requestDto,
			Class<T> responseClass, Callback<T> callback) {
		// TODO Auto-generated method stub
		
	}

}
