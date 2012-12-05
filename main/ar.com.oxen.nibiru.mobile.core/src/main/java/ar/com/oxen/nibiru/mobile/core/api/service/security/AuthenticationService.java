package ar.com.oxen.nibiru.mobile.core.api.service.security;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;

/**
 * A remote authentication service.
 */
public interface AuthenticationService {
	/**
	 * Performs a remote login.
	 * 
	 * @param username
	 *            The username
	 * @param password
	 *            The password
	 * @param callback
	 *            A callback returning the user DTO
	 */
	void login(String username, String password, Callback<UserDto> callback);
}
