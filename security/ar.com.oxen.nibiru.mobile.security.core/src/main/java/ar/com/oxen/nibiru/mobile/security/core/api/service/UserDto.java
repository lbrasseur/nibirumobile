package ar.com.oxen.nibiru.mobile.security.core.api.service;

/**
 * A DTO for transferring user data.
 */
public interface UserDto {
	String getFirstName();

	String getLastName();

	void setFirstName(String firstName);

	void setLastName(String lastName);
}
