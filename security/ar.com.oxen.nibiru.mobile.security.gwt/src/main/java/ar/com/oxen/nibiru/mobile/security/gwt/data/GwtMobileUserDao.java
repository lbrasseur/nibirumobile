package ar.com.oxen.nibiru.mobile.security.gwt.data;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nullable;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.gwt.data.CallbackAdapter;
import ar.com.oxen.nibiru.mobile.gwt.data.ScalarCallbackAdapter;
import ar.com.oxen.nibiru.mobile.security.core.api.data.User;
import ar.com.oxen.nibiru.mobile.security.core.api.data.UserDao;

import com.google.gwt.core.client.GWT;
import com.gwtmobile.persistence.client.Entity;
import com.gwtmobile.persistence.client.Persistence;

public class GwtMobileUserDao implements UserDao {
	private final Entity<PUser> entity = GWT.create(PUser.class);

	@Override
	public void findByName(String username, Callback<User> callback) {
		checkNotNull(username);
		checkNotNull(callback);
		this.entity.findBy("Username", username,
				new ScalarCallbackAdapter<User, PUser>(callback));
	}

	@Override
	public User create(String username, String passwordHash,
			@Nullable String firstName, @Nullable String lastName) {
		checkNotNull(username);
		checkNotNull(passwordHash);
		PUser puser = entity.newInstance();
		puser.setUsername(username);
		puser.setPasswordHash(passwordHash);
		puser.setFirstName(firstName);
		puser.setLastName(lastName);
		Persistence.add(puser);
		return puser;
	}

	@Override
	public void deleteAll(Callback<Void> callback) {
		checkNotNull(callback);
		entity.all().destroyAll(new CallbackAdapter(callback));
	}
}
