package ar.com.oxen.nibiru.mobile.security.core.api.business;

/**
 * A manager for hashing operations.
 */
public interface HashManager {
	/**
	 * Calculates a hash.
	 * 
	 * @param data
	 *            The data
	 * @return The hash
	 */
	String hash(String data);
}
