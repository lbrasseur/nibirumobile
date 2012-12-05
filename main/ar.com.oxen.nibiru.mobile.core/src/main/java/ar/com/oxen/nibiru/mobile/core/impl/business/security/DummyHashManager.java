package ar.com.oxen.nibiru.mobile.core.impl.business.security;

import ar.com.oxen.nibiru.mobile.core.api.business.security.HashManager;

public class DummyHashManager implements HashManager {
	@Override
	public String hash(String data) {
		return data;
	}
}
