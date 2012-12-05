package ar.com.oxen.nibiru.mobile.core.api.ui.mvp;

/**
 * Something that is both, {@link TakesValue} and {@link HasChangeHandler}
 * 
 * @param <T>
 *            The value type
 */
public interface HasValue<T> extends TakesValue<T>, HasChangeHandler {
}
