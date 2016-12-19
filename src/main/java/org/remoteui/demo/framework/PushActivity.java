/** 
 * Created on 02.06.2015 
 * 
 * © 2015 Daniel Thommes, All Rights Reserved
 */
package org.remoteui.demo.framework;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

import javax.management.MBeanServerConnection;

import org.remoteui.annotation.Activity;
import org.remoteui.webapp.WebActivity;

import com.sun.management.OperatingSystemMXBean;

/**
 * 
 *
 * @author Daniel Thommes
 */
@SuppressWarnings("restriction")
@Activity(id = "framework:push", layout = "push.layout.mv")
public class PushActivity extends WebActivity {

	private static Boolean mutex = new Boolean(true);

	private static Timer timer = new Timer("PushTimer", true);

	private static Set<PushActivity> listeners = Collections
			.newSetFromMap(new ConcurrentHashMap<PushActivity, Boolean>());

	private static volatile UpdateTask updateTask;

	private static OperatingSystemMXBean osMBean;

	static {
		MBeanServerConnection mbsc = ManagementFactory.getPlatformMBeanServer();
		try {
			osMBean = ManagementFactory.newPlatformMXBeanProxy(mbsc,
					ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME,
					OperatingSystemMXBean.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static class UpdateTask extends TimerTask {
		@Override
		public void run() {
			double systemCpuLoad = osMBean.getSystemCpuLoad();
			for (PushActivity pushActivity : listeners) {
				pushActivity.push(systemCpuLoad);
			}
		}
	}

	private DecimalFormat df = new DecimalFormat("##0");

	public String value = "...";

	public void push(double systemCpuLoad) {
		value = df.format(systemCpuLoad * 100) + "%";
		firePropertyChanged("value");
	}

	@Override
	protected void onStart() {
		super.onStart();
		addListener();
	}

	@Override
	protected void onStop() {
		super.onStop();
		removeListener();
	}

	@Override
	protected void onConnectionClosed() {
		super.onConnectionClosed();
		removeListener();
	}

	private void addListener() {
		listeners.add(this);
		synchronized (mutex) {
			if (updateTask == null) {
				updateTask = new UpdateTask();
				timer.schedule(updateTask, 0, 1000);
			}
		}
	}

	private void removeListener() {
		listeners.remove(this);
		synchronized (mutex) {
			if (updateTask != null) {
				updateTask.cancel();
				updateTask = null;
			}
		}
	}

}
