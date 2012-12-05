package ar.com.oxen.nibiru.mobile.gwt.geolocation;

import ar.com.oxen.nibiru.mobile.core.api.geolocation.Coordinates;
import ar.com.oxen.nibiru.mobile.core.api.geolocation.Position;

public class PositionAdapter implements Position {
	private com.googlecode.gwtphonegap.client.geolocation.Position position;

	public PositionAdapter(
			com.googlecode.gwtphonegap.client.geolocation.Position position) {
		super();
		this.position = position;
	}

	@Override
	public Coordinates getCoordinates() {
		return new CoordinatesAdapter(this.position.getCoordinates());
	}

	@Override
	public long getTimeStamp() {
		return this.position.getTimeStamp();
	}
}
