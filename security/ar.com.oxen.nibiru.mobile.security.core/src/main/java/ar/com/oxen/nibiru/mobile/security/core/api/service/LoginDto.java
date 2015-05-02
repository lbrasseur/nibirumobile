package ar.com.oxen.nibiru.mobile.security.core.api.service;

/**
 * A DTO for transferring login request data.
 */
public interface LoginDto {
	String getUsername();

	String getPassword();

	void setUsername(String username);

	void setPassword(String password);
}
