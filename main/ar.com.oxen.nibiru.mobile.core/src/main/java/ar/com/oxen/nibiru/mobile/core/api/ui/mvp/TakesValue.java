package ar.com.oxen.nibiru.mobile.core.api.ui.mvp;

/**
 * Something that can holds a value.
 * 
 * @param <T>
 *            The value type
 */
public interface TakesValue<T> {
	/**
	 * @param value
	 *            The value
	 */
	void setValue(T value);

	/**
	 * @return The value
	 */
	T getValue();
}
