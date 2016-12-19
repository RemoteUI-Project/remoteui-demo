/** 
 * Created on 01.05.2014 
 * 
 * © 2014 Daniel Thommes, All Rights Reserved
 */
package org.remoteui.demo.ui.layout;

import java.util.Arrays;
import java.util.List;

import org.remoteui.annotation.Activity;
import org.remoteui.webapp.WebActivity;

/**
 * 
 * 
 * @author Daniel Thommes
 */
@Activity(id = "widget:listviews", layout = "listviews.layout.mv")
public class ListViewsActivity extends WebActivity {

	public List<String> listItems = Arrays.asList(new String[] { "Dr. No", "From Russia with Love",
			"Goldfinger", "Thunderball", "You Only Live Twice", "On Her Majesty's Secret Service",
			"Diamonds Are Forever", "Live and Let Die", "The Man with the Golden Gun",
			"The Spy Who Loved Me", "Moonraker", "For Your Eyes Only", "Octopussy",
			"A View to a Kill", "The Living Daylights", "Licence to Kill", "GoldenEye",
			"Tomorrow Never Dies", "The World Is Not Enough", "Die Another Day", "Casino Royale",
			"Quantum of Solace", "Skyfall" });

	public void setListItems(List<String> listItems) {
		this.listItems = listItems;
	}

	public void onItemClicked(int index) {
		showToast("You clicked " + listItems.get(index) + ".", false);
	}
}
