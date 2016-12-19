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

import org.remoteui.annotation.Activity;
import org.remoteui.webapp.WebActivity;

/**
 * Activity demonstrating the use of a navigation drawer
 * 
 * @author Daniel Thommes
 */
@Activity(id = "widget:drawer", layout = "drawer.layout.xml")
public class DrawerActivity extends WebActivity {

	public String contentText = "Select an item in the drawer.";

	public void onItemSelected(String text) {
		contentText = "You selected " + text + ".";
		firePropertyChanged("contentText");
	}

}
