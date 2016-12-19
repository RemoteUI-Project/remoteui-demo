/** 
 * Created on 21.07.2015 
 * 
 * © 2015 Daniel Thommes, All Rights Reserved
 */
package org.remoteui.demo.ui.charts;

import java.util.List;

import javax.annotation.PostConstruct;

import org.remoteui.webapp.WebActivity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 *
 * @author Daniel Thommes
 */
public abstract class AbsPopulationActivity extends WebActivity {

	public String selectedItem;

	public List<String> selectBoxItems;

	protected static String[] labels = new String[] { "below 3", "3 -  6", "6 - 10", "10 - 15",
			"15 - 18", "18 - 20", "20 - 25", "25 - 30", "30 - 35", "35 - 40", "40 - 45", "45 - 50",
			"50 - 55", "55 - 60", "60 - 65", "65 - 75", "above 75" };

	@Autowired
	protected PopulationDao dao;

	boolean fired = false;

	/**
	 * 
	 */
	@PostConstruct
	public void init() {
		selectBoxItems = dao.getLocations();
		createData(selectBoxItems.get(0));
	}

	@Override
	protected void onStart() {
		super.onStart();
		fired = false;
	}

	public void onItemSelected(String item) {
		if (!fired) {
			// TODO hack around the selectbox bug
			fired = true;
			return;
		}
		createData(item);
		firePropertyChanged("data");
		firePropertyChanged("selectedItem");
	}

	/**
	 * @param string
	 */
	abstract void createData(String location);

}
