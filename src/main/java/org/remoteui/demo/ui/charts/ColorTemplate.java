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
import java.util.List;

import org.remoteui.layout.Color;

/**
 * Class that holds predefined color integer arrays and convenience methods for
 * loading colors from resources.
 * 
 * @author Philipp Jahoda
 */
public class ColorTemplate {

	public static final int COLOR_NONE = -1;

	/**
	 * THE COLOR THEMES ARE PREDEFINED (predefined color integer arrays), FEEL
	 * FREE TO CREATE YOUR OWN WITH AS MANY DIFFERENT COLORS AS YOU WANT
	 */
	public static final int[] LIBERTY_COLORS = { Color.rgb(207, 248, 246), Color.rgb(148, 212, 212),
			Color.rgb(136, 180, 187), Color.rgb(118, 174, 175), Color.rgb(42, 109, 130) };
	public static final int[] JOYFUL_COLORS = { Color.rgb(217, 80, 138), Color.rgb(254, 149, 7),
			Color.rgb(254, 247, 120), Color.rgb(106, 167, 134), Color.rgb(53, 194, 209) };
	public static final int[] PASTEL_COLORS = { Color.rgb(64, 89, 128), Color.rgb(149, 165, 124),
			Color.rgb(217, 184, 162), Color.rgb(191, 134, 134), Color.rgb(179, 48, 80) };
	public static final int[] COLORFUL_COLORS = { Color.rgb(193, 37, 82), Color.rgb(255, 102, 0),
			Color.rgb(245, 199, 0), Color.rgb(106, 150, 31), Color.rgb(179, 100, 53) };
	public static final int[] VORDIPLOM_COLORS = { Color.rgb(192, 255, 140),
			Color.rgb(255, 247, 140), Color.rgb(255, 208, 140), Color.rgb(140, 234, 255),
			Color.rgb(255, 140, 157) };

	/**
	 * Returns the Android ICS holo blue light color.
	 * 
	 * @return
	 */
	public static int getHoloBlue() {
		return Color.rgb(51, 181, 229);
	}

	/**
	 * Turns an array of colors (integer color values) into an ArrayList of
	 * colors.
	 * 
	 * @param colors
	 * @return
	 */
	public static List<Integer> createColors(int[] colors) {

		List<Integer> result = new ArrayList<Integer>();

		for (int i : colors) {
			result.add(i);
		}

		return result;
	}
}
