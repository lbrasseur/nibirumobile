package ar.com.oxen.nibiru.mobile.core.impl.business.security;

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
		return this.username;
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
