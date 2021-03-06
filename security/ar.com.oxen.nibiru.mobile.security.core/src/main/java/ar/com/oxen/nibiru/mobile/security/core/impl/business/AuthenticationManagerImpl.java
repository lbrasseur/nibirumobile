package ar.com.oxen.nibiru.mobile.security.core.impl.business;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.core.impl.async.ChainCallback;
import ar.com.oxen.nibiru.mobile.security.core.api.business.AuthenticationManager;
import ar.com.oxen.nibiru.mobile.security.core.api.business.HashManager;
import ar.com.oxen.nibiru.mobile.security.core.api.data.User;
import ar.com.oxen.nibiru.mobile.security.core.api.data.UserDao;
import ar.com.oxen.nibiru.mobile.security.core.api.service.AuthenticationService;
import ar.com.oxen.nibiru.mobile.security.core.api.service.UserDto;

public class AuthenticationManagerImpl implements AuthenticationManager {

	private final ProfileImpl profile;
	private final HashManager hashManager;
	private final UserDao userDao;
	private final AuthenticationService authenticationService;

	@Inject
	public AuthenticationManagerImpl(ProfileImpl profile,
			HashManager hashManager, UserDao userDao,
			AuthenticationService authenticationService) {
		this.profile = checkNotNull(profile);
		this.hashManager = checkNotNull(hashManager);
		this.userDao = checkNotNull(userDao);
		this.authenticationService = checkNotNull(authenticationService);
	}

	@Override
	public void login(final String username, final String password,
			final Callback<Boolean> callback) {
		checkNotNull(username);
		checkNotNull(password);
		checkNotNull(callback);
		authenticationService.login(username, password,
				new Callback<UserDto>() {

					@Override
					public void onSuccess(final UserDto userDto) {
						if (userDto != null) {
							userDao.deleteAll(new ChainCallback<Void, Boolean>(
									callback) {

								@Override
								public void onSuccess(Void result) {
									userDao.create(username,
											hashManager.hash(password),
											userDto.getFirstName(),
											userDto.getLastName());

									profile.setUsername(username);
									profile.setFirstName(userDto.getFirstName());
									profile.setLastName(userDto.getLastName());
									profile.setActive(true);
									getChained().onSuccess(true);
								}
							});
						} else {
							profile.setActive(false);
							callback.onSuccess(false);
						}
					}

					@Override
					public void onFailure(Exception reason) {
						localLogin(username, password, callback);
					}
				});
	}

	private void localLogin(final String username, final String password,
			Callback<Boolean> callback) {
		userDao.findByName(username, new ChainCallback<User, Boolean>(
				callback) {

			@Override
			public void onSuccess(User user) {
				if (user != null
						&& user.getPasswordHash().equals(
								hashManager.hash(password))) {
					profile.setUsername(user.getUsername());
					profile.setFirstName(user.getFirstName());
					profile.setLastName(user.getLastName());
					profile.setActive(true);
					getChained().onSuccess(true);
				} else {
					getChained().onSuccess(false);
				}
			}
		});
	}

	@Override
	public void logout(Callback<Boolean> callback) {
		callback.onSuccess(true);
	}
}
