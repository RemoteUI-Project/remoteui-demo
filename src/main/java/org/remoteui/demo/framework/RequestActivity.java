/** 
 * Created on 02.06.2015 
 * 
 * © 2015 Daniel Thommes, All Rights Reserved
 */
package org.remoteui.demo.framework;

import javax.servlet.http.HttpServletRequest;

import org.remoteui.annotation.Activity;
import org.remoteui.webapp.WebActivity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 *
 * @author Daniel Thommes
 */
//@Activity(id = "framework:request", layout = "request.layout.mv")
public class RequestActivity extends WebActivity {

	@Autowired
	private HttpServletRequest request;

	public String message;

	@Override
	protected void onStart() {
		super.onStart();
		String messageParam = request.getParameter("message");
		if (messageParam != null) {
			message = messageParam;
		} else {
			message = "There was no 'message' parameter in your URL.";
		}
	}
}
