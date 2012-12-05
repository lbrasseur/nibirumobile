package ar.com.oxen.nibiru.mobile.gwt.geolocation;

import ar.com.oxen.nibiru.mobile.core.api.geolocation.Coordinates;

public class CoordinatesAdapter implements Coordinates {
	private com.googlecode.gwtphonegap.client.geolocation.Coordinates coordinates;

	public CoordinatesAdapter(
			com.googlecode.gwtphonegap.client.geolocation.Coordinates coordinates) {
		super();
		this.coordinates = coordinates;
	}

	@Override
	public double getLatitude() {
		return this.coordinates.getLatitude();
	}

	@Override
	public double getLongitude() {
		return this.coordinates.getLongitude();
	}

	@Override
	public double getAltitude() {
		return this.coordinates.getAltitude();
	}

	@Override
	public double getAccuracy() {
		return this.coordinates.getAccuracy();
	}

	@Override
	public double getSpeed() {
		return this.coordinates.getSpeed();
	}
}
