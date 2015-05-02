package ar.com.oxen.nibiru.mobile.security.core.api.business;

/**
 * A user profile.
 */
public interface Profile {
	/**
	 * @return True if the provile is valid (authen ticated)
	 */
	boolean isActive();

	/**
	 * @return The username
	 */
	String getUsername();

	/**
	 * @return The first name
	 */
	String getFirstName();

	/**
	 * @return The last name
	 */
	String getLastName();
}
