package ar.com.oxen.nibiru.mobile.security.android.data;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.annotation.Nullable;

import ar.com.oxen.nibiru.mobile.security.core.api.data.User;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "users")
public class UserImpl implements User {
	@DatabaseField(id = true)
	private String username;
	@DatabaseField
	private String passwordHash;
	@DatabaseField
	private String firstName;
	@DatabaseField
	private String lastName;

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void setUsername(String username) {
		checkNotNull(username);
		this.username = username;
	}

	@Override
	public String getPasswordHash() {
		return passwordHash;
	}

	@Override
	public void setPasswordHash(String passwordHash) {
		checkNotNull(username);
		this.passwordHash = passwordHash;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(@Nullable String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(@Nullable String lastName) {
		this.lastName = lastName;
	}
}
