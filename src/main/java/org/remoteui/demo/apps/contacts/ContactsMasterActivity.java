/** 
 * Created on 19.05.2015 
 * 
 * © 2015 Daniel Thommes, All Rights Reserved
 */
package org.remoteui.demo.apps.contacts;

import org.remoteui.annotation.Activity;
import org.remoteui.webapp.WebActivity;

/**
 * 
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
