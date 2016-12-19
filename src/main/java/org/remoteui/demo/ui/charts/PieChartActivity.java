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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.remoteui.annotation.Activity;
import org.remoteui.layout.Color;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.PercentFormatter;

/**
 * Demo for a pie chart
 *
 * @author Daniel Thommes
 */
@Activity(id = "chart:piechart", layout = "piechart.layout.xml")
public class PieChartActivity extends AbsPopulationActivity {

	public PieData data;

	void createData(String location) {
		/*************************************************************
		 * Database Access
		 *************************************************************/
		List<Integer> populationByPlace = dao.getPopulationByPlace(location);
		Integer currentSum = populationByPlace.get(populationByPlace.size() - 1);
		populationByPlace.remove(populationByPlace.size() - 1);
		List<Integer> currentValues = populationByPlace;

		/*************************************************************
		 * Create Chart Data
		 *************************************************************/
		List<Entry> values = new ArrayList<Entry>();
		for (int i = 0; i < currentValues.size(); i++) {
			float value = 100f * (float) currentValues.get(i) / currentSum;
			values.add(new Entry(value, i));
		}

		List<String> xVals = Arrays.asList(labels);

		PieDataSet dataSet = new PieDataSet(values, "Population in Stuttgart");
		dataSet.setSliceSpace(3f);
		// dataSet.setSelectionShift(5f);

		data = new PieData(xVals, dataSet);
		data.setValueFormatter(new PercentFormatter());
		data.setValueTextSize(11f);
		data.setValueTextColor(Color.BLACK);

		List<Integer> colors = new ArrayList<>();
		for (int i = 0; i < 360; i += 19) {
			colors.add(Color.hsb((60 + i) % 360, 80, 100));
		}

		dataSet.setColors(colors);

		selectedItem = location + "\n" + currentSum;
	}
}
