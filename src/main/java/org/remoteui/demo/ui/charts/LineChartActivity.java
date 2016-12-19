/**
 * Created on 05.06.2013
 *
 * © 2013 Daniel Thommes, All Rights Reserved
 */
package org.remoteui.demo.ui.charts;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.remoteui.annotation.Activity;
import org.remoteui.demo.framework.I18nActivity;
import org.remoteui.layout.Color;
import org.remoteui.webapp.WebActivity;
import org.springframework.context.i18n.LocaleContextHolder;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

/**
 * Example for a LineChart controller. For more info how to create the data see
 * the MPAndroidChart Wiki:
 * https://github.com/PhilJay/MPAndroidChart/wiki/Setting-Data
 *
 * @author Daniel Thommes
 */
@Activity(id = "chart:linechart", layout = "linechart.layout.mv")
public class LineChartActivity extends WebActivity {

	/**
	 * Data that are bound to the chart. As the chart functionality is based on
	 * MPAndroidCharts, you use classes from the
	 * com.github.mikephil.charting.data package here.
	 */
	public LineData data;

	/**
	 * Stuff for Internationalization, please {@link I18nActivity} for more
	 * info.
	 */
	private DateFormat dateFormat;

	/**
	 * 
	 */
	public LineChartActivity() {
		dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM,
				LocaleContextHolder.getLocale());
	}

	@Override
	protected void onStart() {
		super.onStart();
		data = createLineData();
	}

	/**
	 * Reloads a random data set.
	 */
	public void onButtonClicked() {
		data = createLineData();
		firePropertyChanged("data");
	}

	/**
	 * Creates a random data set with 100 values.
	 * 
	 * @return
	 */
	private LineData createLineData() {
		int count = 100;
		int halfMinute = 30 * 1000;

		// MR colors ;-)
		int lineColor = Color.BLUE;
		int mrDarkBeige = Color.rgb(178, 177, 168);
		int mrDarkGray = Color.rgb(75, 75, 75);

		// Multiple Lines
		List<LineDataSet> dataSets = new ArrayList<>();
		dataSets.add(createLineDataSet(10, count, lineColor, lineColor, mrDarkGray, mrDarkBeige));
		// Comment in if you need a 2nd line
		// dataSets.add(createLineDataSet(5, count, Color.WHITE, Color.WHITE,
		// mrDarkGray, Color.LTGRAY));

		// x-values
		Date now = new Date();
		long time = now.getTime() / halfMinute * halfMinute;
		List<String> xVals = new ArrayList<String>(count);
		for (int i = count; i > 0; i--) {
			xVals.add(dateFormat.format(new Date(time - i * halfMinute)));
		}

		// create a data object with the datasets
		LineData data = new LineData(xVals, dataSets);
		return data;
	}

	private LineDataSet createLineDataSet(float range, int count, int lineColor, int circleColor,
			int textColor, int fillColor) {
		List<Entry> yVals = new ArrayList<Entry>(count);
		for (int i = 0; i < count; i++) {
			float mult = (range + 1);
			float val = (float) (Math.random() * mult) + 3;
			yVals.add(new Entry(val, i));
		}

		// get the localized title from messages.properties
		String dataTitle = getMessage("linechart.ambientTemperature");

		LineDataSet dataSet = new LineDataSet(yVals, dataTitle);
		dataSet.setColor(lineColor);
		dataSet.setDrawCubic(true);

		dataSet.setValueTextSize(12);
		dataSet.setValueTextColor(textColor);

		// set the line to be drawn like this "- - - - - -"
		// dataSet.enableDashedLine(10f, 5f, 0f);
		dataSet.setLineWidth(2f);

		dataSet.setDrawCircles(true);
		dataSet.setCircleColor(circleColor);
		dataSet.setCircleSize(4f);
		dataSet.setDrawCircleHole(true);

		dataSet.setDrawFilled(true);
		dataSet.setFillAlpha(100);
		dataSet.setFillColor(fillColor);
		return dataSet;
	}
}
