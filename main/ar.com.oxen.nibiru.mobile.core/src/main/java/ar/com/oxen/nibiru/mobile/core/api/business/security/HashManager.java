package ar.com.oxen.nibiru.mobile.core.api.business.security;

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
