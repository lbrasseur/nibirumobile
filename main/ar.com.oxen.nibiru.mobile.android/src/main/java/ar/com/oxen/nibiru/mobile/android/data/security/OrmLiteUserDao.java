package ar.com.oxen.nibiru.mobile.android.data.security;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.core.api.data.security.User;
import ar.com.oxen.nibiru.mobile.core.api.data.security.UserDao;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;

public class OrmLiteUserDao implements UserDao {
	private RuntimeExceptionDao<UserImpl, String> ormLiteDao;

	@Inject
	public OrmLiteUserDao(OrmLiteSqliteOpenHelper helper) {
		super();
		this.ormLiteDao = helper.getRuntimeExceptionDao(UserImpl.class);
	}

	@Override
	public void findByName(String username, Callback<User> callback) {
		try {
			callback.onSuccess(this.ormLiteDao.queryForId(username));
		} catch (Exception e) {
			callback.onFailure(e);
		}
	}

	@Override
	public User create(String username, String passwordHash, String firstName,
			String lastName) {
		UserImpl user = new UserImpl();
		user.setUsername(username);
		user.setPasswordHash(passwordHash);
		user.setFirstName(firstName);
		user.setLastName(lastName);

		this.ormLiteDao.update(user);
		return user;
	}

	@Override
	public void deleteAll(Callback<Void> callback) {
		try {
			// TODO: Tiene que haber una forma mas eficiente de hacer esto
			this.ormLiteDao.delete(this.ormLiteDao.queryForAll());
			callback.onSuccess(null);
		} catch (Exception e) {
			callback.onFailure(e);
		}
	}
}
