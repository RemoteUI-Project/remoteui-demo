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
 * Demo for EditTextViews
 * 
 * @author Daniel Thommes
 */
@Activity(id = "widget:edittextviews", layout = "edittextviews.layout.xml")
public class EditTextViewsActivity extends WebActivity {

	public String standardText;

	public String number;

	public String uri;

	public String email;

	public String phone;

	public String date;

	public String time;

	public String dateAndTime;

	public String personName;

}
