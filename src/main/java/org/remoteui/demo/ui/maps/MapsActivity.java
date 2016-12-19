/** 
 * Created on 07.05.2015 
 * 
 * © 2015 Daniel Thommes, All Rights Reserved
 */
package org.remoteui.demo.ui.maps;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.remoteui.annotation.Activity;
import org.remoteui.protocol.views.RuiMarker;
import org.remoteui.webapp.WebActivity;

/**
 * 
 *
 * @author Daniel Thommes
 */
@Activity(id = "widget:maps", layout = "maps.layout.mv")
public class MapsActivity extends WebActivity {

	public List<RuiMarker> markers = new ArrayList<RuiMarker>();

	public double longitude = 12.492231;
	public double latitude = 41.89021;

	public RuiMarker centeredMarker;

	@PostConstruct
	public void init() {
		markers.add(new RuiMarker("col", getMessage("mapview.colloseumTitle", "Colloseum Rome"),
				41.89021, 12.492231));
		markers.add(new RuiMarker("not", getMessage("mapview.notreDameTitle", "Notre Dame, Paris"),
				48.852968, 2.349902));
		markers.add(
				new RuiMarker("edn", getMessage("mapview.castleEdinburghTitle", "Edinburgh Castle"),
						55.948595, -3.199913));
		markers.add(new RuiMarker("bb", getMessage("mapview.bigBenTitle", "Big Ben, London"),
				51.500729, -0.124625));
		markers.add(new RuiMarker("sl",
				getMessage("mapview.liberty", "Statue of Liberty, New York"), 40.689249, -74.0445));
		markers.add(
				new RuiMarker("hdm", getMessage("mapview.hdmTitle", "Stuttgart Media University"),
						48.74200, 9.10076, getMessage("mapview.hdmSnippet", "Cradle of RemoteUI")));
		markers.add(new RuiMarker("uws",
				getMessage("mapview.uwsTitle", "University of the West of Scotland"), 55.844268,
				-4.430478, getMessage("mapview.uwsSnippet", "Cradle of RemoteUI")));
		centeredMarker = markers.get(0);
	}

	public void onOptionsMenuItemSelected(int index) {
		centeredMarker = markers.get(index);
		firePropertyChanged("centeredMarker");
	}

	public void onMarkerClick(String markerID) {
		for (RuiMarker ruiMarker : markers) {
			if (markerID.equals(ruiMarker.id)) {
				showToast(ruiMarker.title, false);
				break;
			}
		}
	}
}
