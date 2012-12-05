package ar.com.oxen.nibiru.mobile.core.api.service.security;

/**
 * A DTO for transferring user data.
 */
public interface UserDto {
	String getFirstName();

	String getLastName();

	void setFirstName(String firstName);

	void setLastName(String lastName);
}
