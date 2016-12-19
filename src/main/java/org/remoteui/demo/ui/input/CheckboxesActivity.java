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
package org.remoteui.demo.ui.input;

import org.remoteui.annotation.Activity;
import org.remoteui.webapp.WebActivity;

/**
 * Demo for checkboxes
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
