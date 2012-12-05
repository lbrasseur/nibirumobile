package ar.com.oxen.nibiru.mobile.gwt.data.security;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.core.api.data.security.User;
import ar.com.oxen.nibiru.mobile.core.api.data.security.UserDao;
import ar.com.oxen.nibiru.mobile.gwt.data.CallbackAdapter;
import ar.com.oxen.nibiru.mobile.gwt.data.ScalarCallbackAdapter;

import com.google.gwt.core.client.GWT;
import com.gwtmobile.persistence.client.Entity;
import com.gwtmobile.persistence.client.Persistence;

public class GwtMobileUserDao implements UserDao {
	private Entity<PUser> entity = GWT.create(PUser.class);

	@Override
	public void findByName(String username, Callback<User> callback) {
		this.entity.findBy("Username", username,
				new ScalarCallbackAdapter<User, PUser>(callback));
	}

	@Override
	public User create(String username, String passwordHash, String firstName,
			String lastName) {
		PUser puser = this.entity.newInstance();
		puser.setUsername(username);
		puser.setPasswordHash(passwordHash);
		puser.setFirstName(firstName);
		puser.setLastName(lastName);
		Persistence.add(puser);
		return puser;
	}

	@Override
	public void deleteAll(Callback<Void> callback) {
		this.entity.all().destroyAll(new CallbackAdapter(callback));
	}
}
