package ar.com.oxen.nibiru.mobile.security.core.impl.business;

import ar.com.oxen.nibiru.mobile.security.core.api.business.HashManager;

public class DummyHashManager implements HashManager {
	@Override
	public String hash(String data) {
		return data;
	}
}
