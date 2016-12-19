/**
 * Created on 05.06.2013
 *
 * © 2013 Daniel Thommes, All Rights Reserved
 */
package org.remoteui.demo.ui.output;

import java.util.Random;

import org.remoteui.annotation.Activity;
import org.remoteui.webapp.WebActivity;

/**
 *
 *
 * @author Daniel Thommes
 */
@Activity(id = "widget:customviews", layout = "customviews.layout.mv")
public class CustomViewsActivity extends WebActivity {

	public int angle = 179;

	private Random random = new Random();

	public void onButtonClicked() {
		angle = random.nextInt(300);
		firePropertyChanged("angle");
	}
}
