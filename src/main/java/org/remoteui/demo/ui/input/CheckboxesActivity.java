/** 
 * Created on 01.05.2014 
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
@Activity(id = "widget:checkboxes", layout = "checkboxes.layout.xml")
public class CheckboxesActivity extends WebActivity {

	public boolean likePizza = true;
	public boolean likeSpaghetti = false;
	public boolean likeLasagne = false;

	public void setLikePizza(boolean likePizza) {
		this.likePizza = likePizza;
		firePropertyChanged("text");
	}

	public void setLikeSpaghetti(boolean likeSpaghetti) {
		this.likeSpaghetti = likeSpaghetti;
		firePropertyChanged("text");
	}

	public void setLikeLasagne(boolean likeLasagne) {
		this.likeLasagne = likeLasagne;
		firePropertyChanged("text");
	}

	public String getText() {
		String text = "You like ";
		if (likePizza) {
			text += "Pizza";
		}
		if (likeSpaghetti) {
			if (likePizza) {
				text += ", ";
			}
			text += "Spaghetti";
		}
		if (likeLasagne) {
			if (likePizza || likeSpaghetti) {
				text += ", ";
			}
			text += "Lasagne";
		}
		if (!likePizza && !likeSpaghetti && !likeLasagne) {
			text += "nothing at all";
		}
		text += ".";
		return text;
	}
}
