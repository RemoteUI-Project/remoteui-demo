/** 
* Created on 25.11.2016 
* 
* © 2016 Daniel Thommes
*/
package org.remoteui.demo.ui;

import org.remoteui.demo.BaseDemoConfig;
import org.remoteui.webapp.WebActivity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 *
 * @author Daniel Thommes
 */
@Configuration
public class UiConfig extends BaseDemoConfig {

	@Bean
	WebActivity imageViews() {
		return createActivity("widget:imageViews", "output/imageviews.layout.xml", getClass());
	}

	@Bean
	WebActivity buttons() {
		return createActivity("widget:buttons", "input/buttons.layout.xml", getClass());
	}

	@Bean
	WebActivity textViews() {
		return createActivity("widget:textViews", "output/textviews.layout.xml", getClass());
	}

	@Bean
	WebActivity imageButtons() {
		return createActivity("widget:imageButtons", "input/imagebuttons.layout.xml", getClass());
	}

	@Bean
	WebActivity npatch() {
		return createActivity("widget:nPatch", "output/npatch.layout.xml", getClass());
	}

	@Bean
	WebActivity statefulbuttons() {
		return createActivity("widget:statefulbuttons", "input/statefulbuttons.layout.xml",
				getClass());
	}

	@Bean
	WebActivity videoviews() {
		return createActivity("widget:videoviews", "output/videoviews.layout.mv", getClass());
	}
}
