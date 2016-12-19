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
package org.remoteui.demo.framework;

import javax.servlet.http.HttpServletRequest;

import org.remoteui.webapp.WebActivity;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This activity demonstrates accessing the HttpServlet request to extract
 * things like request parameters and headers. Currently, it is deactived as
 * with JSR 356 the servlet request is not available - we have a work-around but
 * not tested it.
 *
 * @author Daniel Thommes
 */
// @Activity(id = "framework:request", layout = "request.layout.mv")
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
