package ar.com.oxen.nibiru.mobile.core.api.business.security;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;

/**
 * Manager for performing authentication operations.
 */
public interface AuthenticationManager {
	/**
	 * Performs a login.
	 * 
	 * @param username
	 *            The username
	 * @param password
	 *            The password
	 * @param callback
	 *            A callback notifying true if the login was successful
	 */
	void login(String username, String password, Callback<Boolean> callback);

	/**
	 * Performs a logout.
	 * 
	 * @param callback
	 *            A callback notifying true if the login was successful
	 */
	void logout(Callback<Boolean> callback);
}
