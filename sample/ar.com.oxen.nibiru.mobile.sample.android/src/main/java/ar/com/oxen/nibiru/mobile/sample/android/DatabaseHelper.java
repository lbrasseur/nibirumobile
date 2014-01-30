package ar.com.oxen.nibiru.mobile.sample.android;

import static com.google.common.base.Preconditions.checkNotNull;

import java.sql.SQLException;

import javax.inject.Inject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import ar.com.oxen.nibiru.mobile.android.data.security.UserImpl;
import ar.com.oxen.nibiru.mobile.core.api.config.AppName;
import ar.com.oxen.nibiru.mobile.core.api.config.AppVersion;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {
	@Inject
	public DatabaseHelper(Context context, @AppName String appName,
			@AppVersion Integer appVersion) {
		super(context, appName, null, appVersion);
	}

	@Override
	public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
		checkNotNull(db);
		checkNotNull(connectionSource);
		try {
			TableUtils.createTable(connectionSource, UserImpl.class);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		UserImpl user = new UserImpl();
		user.setUsername("p");
		user.setPasswordHash("a");
		user.setFirstName("Pepe");
		user.setLastName("Sanchez");
		getRuntimeExceptionDao(UserImpl.class).create(user);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource,
			int oldVersion, int newVersion) {
	}
}
