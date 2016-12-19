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
package org.remoteui.demo.ui.charts;

import java.util.List;

import javax.annotation.PostConstruct;

import org.remoteui.webapp.WebActivity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Base activity for all charts, which provides the data. It is also an example
 * of how to handle JDBC in a RemoteUI app.
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
