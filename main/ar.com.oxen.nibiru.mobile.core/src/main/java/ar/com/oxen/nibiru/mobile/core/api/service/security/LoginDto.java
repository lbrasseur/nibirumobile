package ar.com.oxen.nibiru.mobile.core.api.service.security;

/**
 * A DTO for transferring login request data.
 */
public interface LoginDto {
	String getUsername();

	String getPassword();

	void setUsername(String username);

	void setPassword(String password);
}
