package ar.com.oxen.nibiru.mobile.java.thread;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.core.api.ui.Looper;

import com.google.common.base.Supplier;

public class ThreadHelper {
	private final Looper looper;

	@Inject
	public ThreadHelper(Looper looper) {
		this.looper = checkNotNull(looper);
	}

	public <T>  void runOnSameThread(Supplier<T> callable, Callback<T> callback) {
		checkNotNull(callable);
		checkNotNull(callback);
		try {
			callback.onSuccess(callable.get());
		} catch (Exception e) {
			callback.onFailure(e);
		}
	}
	
	public <T> void runOnNewThread(final Supplier<T> callable, final Callback<T> callback) {
		checkNotNull(callable);
		checkNotNull(callback);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					final T result = callable.get();
					looper.post(new Runnable() {
						@Override
						public void run() {
							callback.onSuccess(result);
						}
					});
				} catch (final Exception e) {
					looper.post(new Runnable() {
						@Override
						public void run() {
							callback.onFailure(e);
						}
					});
				}
			}
		}).start();
	}
}
