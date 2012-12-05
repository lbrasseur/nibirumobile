package ar.com.oxen.nibiru.mobile.core.api.data.security;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;

/**
 * A DAO for users.
 */
public interface UserDao {
	/**
	 * Loads an user.
	 * 
	 * @param username
	 *            The username to look for
	 * @param callback
	 *            A callback returning the user domain object
	 */
	void findByName(String username, Callback<User> callback);

	/**
	 * Creates a user
	 * 
	 * @param username
	 *            The user name
	 * @param passwordHash
	 *            The password hash
	 * @param firstName
	 *            First name
	 * @param lastName
	 *            Last name
	 * @return The user domain object
	 */
	User create(String username, String passwordHash, String firstName,
			String lastName);

	/**
	 * Deletes all the users.
	 * 
	 * @param callback
	 *            A callback
	 */
	void deleteAll(Callback<Void> callback);
}
