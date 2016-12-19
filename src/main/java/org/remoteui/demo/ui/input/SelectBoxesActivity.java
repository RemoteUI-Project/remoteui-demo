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

import java.util.Arrays;
import java.util.List;

import org.remoteui.annotation.Activity;
import org.remoteui.webapp.WebActivity;

/**
 * Demo for SelectBoxes
 * 
 * @author Daniel Thommes
 */
@Activity(id = "widget:selectboxes", layout = "selectboxes.layout.mv")
public class SelectBoxesActivity extends WebActivity {

	private static String[] pasta = new String[] { "Spaghetti", "Regatoni", "Lasagne", "Linguine",
			"Ravioli", "Tortellini", "Farfalle", "Capelletti" };

	private String currentSelection = null;
	private String currentOtherSelection = null;

	public List<String> selectBoxItems = Arrays.asList("Sub Light Speed", "Light Speed",
			"Ridiculous Speed", "Ludicrous Speed (please belt on)");

	/**
	 * @param selectBoxItems
	 *            the selectBoxItems to set
	 */
	public void setSelectBoxItems(List<String> selectBoxItems) {
		this.selectBoxItems = selectBoxItems;
	}

	@Override
	protected void onStart() {
		currentSelection = null;
		currentOtherSelection = null;
		super.onStart();
	}

	public void onItemSelected(int index) {
		if (currentSelection != null) {
			showToast("You selected " + pasta[index] + ".", false);
		}
		currentSelection = pasta[index];
	}

	public void onOtherItemSelected(int index) {
		if (currentOtherSelection != null) {
			showToast("Changed speed to " + selectBoxItems.get(index) + ".", false);
		}
		currentOtherSelection = selectBoxItems.get(index);
	}
}
