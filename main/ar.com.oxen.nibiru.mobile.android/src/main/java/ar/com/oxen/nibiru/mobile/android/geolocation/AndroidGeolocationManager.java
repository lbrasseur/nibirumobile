package ar.com.oxen.nibiru.mobile.android.geolocation;

import javax.inject.Inject;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.core.api.geolocation.GeolocationManager;
import ar.com.oxen.nibiru.mobile.core.api.geolocation.Position;

public class AndroidGeolocationManager implements GeolocationManager {
	private LocationManager locationManager;

	@Inject
	public AndroidGeolocationManager(LocationManager locationManager,
			Activity activity) {
		super();
		this.locationManager = locationManager;
	}

	@Override
	public void watchPosition(final Callback<Position> callback) {
		// TODO El tipo de provider deberia ser configurable.
		this.locationManager.requestLocationUpdates(
				LocationManager.GPS_PROVIDER, 1000, 10, new LocationListener() {
					@Override
					public void onLocationChanged(Location location) {
						if (location != null) {
							callback.onSuccess(new LocationAdapter(location));
						} else {
							callback.onFailure(new IllegalStateException(
									"No location read"));
						}
					}

					@Override
					public void onStatusChanged(String arg0, int arg1,
							Bundle arg2) {
					}

					@Override
					public void onProviderEnabled(String arg0) {
					}

					@Override
					public void onProviderDisabled(String arg0) {
					}

				});
	}
}
