package ar.com.oxen.nibiru.mobile.core.impl.business.security;

import javax.annotation.Nullable;
import javax.inject.Singleton;

import ar.com.oxen.nibiru.mobile.core.api.business.security.Profile;

@Singleton
public class ProfileImpl implements Profile {
	private boolean active;
	private String username;
	private String firstName;
	private String lastName;

	@Override
	public boolean isActive() {
		return active;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	public void setUsername(@Nullable String userName) {
		this.username = userName;
	}

	public void setFirstName(@Nullable String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(@Nullable String lastName) {
		this.lastName = lastName;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
