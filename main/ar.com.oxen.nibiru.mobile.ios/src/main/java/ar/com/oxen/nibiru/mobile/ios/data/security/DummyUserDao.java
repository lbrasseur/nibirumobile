package ar.com.oxen.nibiru.mobile.ios.data.security;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.core.api.data.security.User;
import ar.com.oxen.nibiru.mobile.core.api.data.security.UserDao;

public class DummyUserDao implements UserDao {

	@Override
	public void findByName(String username, Callback<User> callback) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User create(String username, String passwordHash, String firstName,
			String lastName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll(Callback<Void> callback) {
		// TODO Auto-generated method stub
		
	}

}
