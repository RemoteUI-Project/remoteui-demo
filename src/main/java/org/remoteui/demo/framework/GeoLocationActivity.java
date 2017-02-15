/** 
* Created on 22.12.2016 
* 
* © 2016 Daniel Thommes
*/
package org.remoteui.demo.framework;

import org.remoteui.annotation.Activity;
import org.remoteui.webapp.WebActivity;
import org.remoteui.webapp.plugin.geolocation.GeoLocation;
import org.remoteui.webapp.plugin.geolocation.GeolocationPlugin;

/**
 * 
 *
 * @author Daniel Thommes
 */
@Activity(id = "framework:geolocation")
public class GeoLocationActivity extends WebActivity {

	public GeoLocation location = null;

	@Override
	protected void onStart() {
		super.onStart();
		// getLocation();
	}

	public void getLocation(boolean useGps) {
		firePropertyChanged("location");
		getWebApp().getPlugin(GeolocationPlugin.class).getGeolocation(useGps, 10000, location -> {
			this.location = location;
			firePropertyChanged("location");
		});
	}

}
