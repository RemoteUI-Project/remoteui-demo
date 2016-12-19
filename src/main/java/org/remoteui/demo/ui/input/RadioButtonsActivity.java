/** 
 * Created on 30.05.2014 
 * 
 * © 2014 Daniel Thommes, All Rights Reserved
 */
package org.remoteui.demo.ui.input;

import org.remoteui.annotation.Activity;
import org.remoteui.webapp.WebActivity;

/**
 * 
 * 
 * @author Daniel Thommes
 */
@Activity(id="widget:radiobuttons", layout="radiobuttons.layout.xml")
public class RadioButtonsActivity extends WebActivity {

	public Decision decision;

	private boolean singleButtonChecked = false;

	public boolean isSingleButtonChecked() {
		return singleButtonChecked;
	}

	public void setSingleButtonChecked(boolean singleButtonChecked) {
		this.singleButtonChecked = singleButtonChecked;
		showToast("You prefer pizza!", false);
	}

	public void reset() {
		singleButtonChecked = false;
	}

	public String getDecisionText() {
		if (decision == null) {
			return "Please make a decision!";
		}
		return "Your decision is \"" + decision.toString().toUpperCase()
				+ "\".";
	}

}
