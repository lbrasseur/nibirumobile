package ar.com.oxen.nibiru.mobile.android.data.security;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import ar.com.oxen.nibiru.mobile.core.api.data.security.User;

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
		this.username = username;
	}

	@Override
	public String getPasswordHash() {
		return passwordHash;
	}

	@Override
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
