/** 
 * Created on 12.09.2014 
 * 
 * © 2014 Daniel Thommes, All Rights Reserved
 */
package org.remoteui.demo.ui.layout;

import org.remoteui.annotation.Activity;
import org.remoteui.webapp.WebActivity;

/**
 * 
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
