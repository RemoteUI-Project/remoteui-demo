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

import org.remoteui.webapp.WebActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This activity is not part of the demo but demonstrates the different
 * lifecycle events.
 *
 * @author Daniel Thommes
 */
public class LifecycleActivity extends WebActivity {

	/**
	 * SLF4J Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(LifecycleActivity.class);

	public String message = "";

	private LifecycleActivity secondActivity;

	public void setSecondActivity(LifecycleActivity secondActivity) {
		this.secondActivity = secondActivity;
	}

	@Override
	protected void onStart() {
		super.onStart();
		logger.info("****** LifecycleActivity was started. ******");
	}

	@Override
	protected void onStop() {
		super.onStop();
		logger.info("****** LifecycleActivity was stopped. ******");
	}

	@Override
	protected void onConnectionClosed() {
		super.onConnectionClosed();
		logger.info("****** LifecycleActivity recognized the onConnectionClosed event. ******");
	}

	public void onShowClicked() {
		secondActivity.message = message;
		startActivity(secondActivity);
	}
}
