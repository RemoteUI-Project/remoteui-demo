/** 
 * Created on 02.05.2014 
 * 
 * © 2014 Daniel Thommes, All Rights Reserved
 */
package org.remoteui.demo.ui.input;

import org.remoteui.annotation.Activity;
import org.remoteui.webapp.WebActivity;

/**
 * 
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
