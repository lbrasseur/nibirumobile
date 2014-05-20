package ar.com.oxen.nibiru.mobile.core.api.ui.mvp;

import javax.annotation.Nullable;


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
	void setValue(@Nullable T value);

	/**
	 * @return The value
	 */
	@Nullable
	T getValue();
}
