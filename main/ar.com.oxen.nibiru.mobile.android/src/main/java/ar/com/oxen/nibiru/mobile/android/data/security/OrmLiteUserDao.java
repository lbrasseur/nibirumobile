package ar.com.oxen.nibiru.mobile.android.data.security;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.core.api.data.security.User;
import ar.com.oxen.nibiru.mobile.core.api.data.security.UserDao;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.sun.istack.internal.Nullable;

public class OrmLiteUserDao implements UserDao {
	private final RuntimeExceptionDao<UserImpl, String> ormLiteDao;

	@Inject
	public OrmLiteUserDao(OrmLiteSqliteOpenHelper helper) {
		checkNotNull(helper);
		this.ormLiteDao = helper.getRuntimeExceptionDao(UserImpl.class);
	}

	@Override
	public void findByName(String username, Callback<User> callback) {
		checkNotNull(username);
		checkNotNull(callback);
		try {
			callback.onSuccess(ormLiteDao.queryForId(username));
		} catch (Exception e) {
			callback.onFailure(e);
		}
	}

	@Override
	public User create(String username, String passwordHash,
			@Nullable String firstName, @Nullable String lastName) {
		checkNotNull(username);
		checkNotNull(passwordHash);
		UserImpl user = new UserImpl();
		user.setUsername(username);
		user.setPasswordHash(passwordHash);
		user.setFirstName(firstName);
		user.setLastName(lastName);

		ormLiteDao.update(user);
		return user;
	}

	@Override
	public void deleteAll(Callback<Void> callback) {
		checkNotNull(callback);
		try {
			// TODO: Tiene que haber una forma mas eficiente de hacer esto
			ormLiteDao.delete(ormLiteDao.queryForAll());
			callback.onSuccess(null);
		} catch (Exception e) {
			callback.onFailure(e);
		}
	}
}
