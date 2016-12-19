/** 
 * Created on 21.07.2015 
 * 
 * © 2015 Daniel Thommes, All Rights Reserved
 */
package org.remoteui.demo.ui.charts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.remoteui.annotation.Activity;
import org.remoteui.layout.Color;

import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

/**
 * 
 *
 * @author Daniel Thommes
 */

@Activity(id = "chart:barchart", layout = "barchart.layout.xml")
public class BarChartActivity extends AbsPopulationActivity {

	public BarData data;

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
		List<BarEntry> values = new ArrayList<BarEntry>();

		for (int i = 0; i < currentValues.size(); i++) {
			float value = currentValues.get(i);
			values.add(new BarEntry(value, i));
		}

		List<String> xVals = Arrays.asList(labels);

		BarDataSet dataSet = new BarDataSet(values, "Population in Stuttgart");

		data = new BarData(xVals, dataSet);
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
