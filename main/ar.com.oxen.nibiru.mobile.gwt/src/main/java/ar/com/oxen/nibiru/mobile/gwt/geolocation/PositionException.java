package ar.com.oxen.nibiru.mobile.gwt.geolocation;

import com.googlecode.gwtphonegap.client.geolocation.PositionError;

public class PositionException extends RuntimeException {
	private static final long serialVersionUID = -6777629815610377078L;
	private PositionError positionError;

	public PositionException(PositionError positionError) {
		super();
		this.positionError = positionError;
	}

	public PositionError getPositionError() {
		return positionError;
	}

}
