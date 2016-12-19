/** 
 * Created on 07.06.2015 
 * 
 * © 2015 Daniel Thommes, All Rights Reserved
 */
package org.remoteui.demo.framework;

import org.remoteui.webapp.WebActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 *
 * @author Daniel Thommes
 */
public class LifecycleActivity extends WebActivity {

	/**
	 * SLF4J Logger
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(LifecycleActivity.class);

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
