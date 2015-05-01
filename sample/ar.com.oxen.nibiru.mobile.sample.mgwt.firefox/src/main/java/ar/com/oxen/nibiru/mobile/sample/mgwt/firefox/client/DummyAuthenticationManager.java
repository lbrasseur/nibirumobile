package ar.com.oxen.nibiru.mobile.sample.mgwt.firefox.client;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.core.api.business.security.AuthenticationManager;
import ar.com.oxen.nibiru.mobile.core.impl.business.security.ProfileImpl;

public class DummyAuthenticationManager implements AuthenticationManager {
	private final ProfileImpl profile;

	@Inject
	public DummyAuthenticationManager(ProfileImpl profile) {
		this.profile = checkNotNull(profile);
	}

	@Override
	public void login(String username, String password,
			Callback<Boolean> callback) {
		profile.setActive(true);
		profile.setFirstName("Guest");
		profile.setLastName("Guest");
		profile.setUsername("g");
		callback.onSuccess(true);
	}

	@Override
	public void logout(Callback<Boolean> callback) {
		// TODO Auto-generated method stub

	}

}
