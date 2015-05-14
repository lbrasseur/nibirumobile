package ar.com.oxen.nibiru.mobile.security.ios.data;

import java.util.Map;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.security.core.api.data.User;
import ar.com.oxen.nibiru.mobile.security.core.api.data.UserDao;

import com.google.common.collect.Maps;

/**
 * Dummy in-memory user DAO implementation (waiting for RoboVM support for
 * CoreData).
 */
// TODO Write the final version.
public class DummyUserDao implements UserDao {
	private Map<String, User> users = Maps.newConcurrentMap();

	@Override
	public void findByName(String username, Callback<User> callback) {
		callback.onSuccess(users.get(username));
	}

	@Override
	public User create(String username, String passwordHash, String firstName,
			String lastName) {
		User user = new UserImpl();
		user.setUsername(username);
		user.setPasswordHash(passwordHash);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		users.put(username, user);
		return user;
	}

	@Override
	public void deleteAll(Callback<Void> callback) {
		users.clear();
		callback.onSuccess(null);
	}

}
