/*******************************************************************************
 * Copyright 2016 Daniel Thommes
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.remoteui.demo.ui.layout;

import java.util.Arrays;
import java.util.List;

import org.remoteui.annotation.Activity;
import org.remoteui.webapp.WebActivity;

/**
 * Demo for ListViews
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
