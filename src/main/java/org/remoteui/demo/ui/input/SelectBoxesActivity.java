/** 
 * Created on 01.05.2014 
 * 
 * © 2014 Daniel Thommes, All Rights Reserved
 */
package org.remoteui.demo.ui.input;

import java.util.Arrays;
import java.util.List;

import org.remoteui.annotation.Activity;
import org.remoteui.webapp.WebActivity;

/**
 * 
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
