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
 * Demo for RadioButtons
 * 
 * @author Daniel Thommes
 */
@Activity(id = "widget:radiobuttons", layout = "radiobuttons.layout.xml")
public class RadioButtonsActivity extends WebActivity {

	/**
	 * Bound enumration
	 */
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
		firePropertyChanged("singleButtonChecked");
	}

	public String getDecisionText() {
		if (decision == null) {
			return "Please make a decision!";
		}
		return "Your decision is \"" + decision.toString().toUpperCase() + "\".";
	}

}
