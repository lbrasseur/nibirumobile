package ar.com.oxen.nibiru.mobile.android.geolocation;

import android.location.Location;
import ar.com.oxen.nibiru.mobile.core.api.geolocation.Coordinates;
import ar.com.oxen.nibiru.mobile.core.api.geolocation.Position;

public class LocationAdapter implements Position, Coordinates {
	private Location location;

	public LocationAdapter(Location location) {
		super();
		this.location = location;
	}

	@Override
	public Coordinates getCoordinates() {
		return this;
	}

	@Override
	public long getTimeStamp() {
		return this.location.getTime();
	}

	@Override
	public double getLatitude() {
		return this.location.getLatitude();
	}

	@Override
	public double getLongitude() {
		return this.location.getLongitude();
	}

	@Override
	public double getAltitude() {
		return this.location.getAltitude();
	}

	@Override
	public double getAccuracy() {
		return this.location.getAccuracy();
	}

	@Override
	public double getSpeed() {
		return this.location.getSpeed();
	}
}
