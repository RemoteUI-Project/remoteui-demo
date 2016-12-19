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
package org.remoteui.demo.apps.contacts;

import org.remoteui.annotation.Activity;
import org.remoteui.webapp.WebActivity;

/**
 * The master activity for the contacts demo app. Currently, the tabs are
 * realized with a deprecated approach by controlling visibility of different
 * buttons. Please use the new TabBar instead.
 *
 * @author Daniel Thommes
 */
@Activity(id = "contactsMaster", layout = "contacts-master.layout.mv")
public class ContactsMasterActivity extends WebActivity {

	public boolean favoritesVisible = false;

	public void onTabClicked(boolean favorites) {
		favoritesVisible = favorites;
		firePropertyChanged("favoritesVisible");
	}

}
