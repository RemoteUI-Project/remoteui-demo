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
package org.remoteui.demo.ui.output;

import java.util.Random;

import org.remoteui.annotation.Activity;
import org.remoteui.webapp.WebActivity;

/**
 * Demo for a custom view. Please find the logic of the view in the file
 * "customview.mvel" within the resources.
 *
 * @author Daniel Thommes
 */
@Activity(id = "widget:customviews", layout = "customviews.layout.mv")
public class CustomViewsActivity extends WebActivity {

	public int angle = 179;

	private Random random = new Random();

	public void onButtonClicked() {
		angle = random.nextInt(300);
		firePropertyChanged("angle");
	}
}
