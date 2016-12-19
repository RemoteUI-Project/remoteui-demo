/** 
* Created on 25.11.2016 
* 
* © 2016 Daniel Thommes
*/
package org.remoteui.demo.ui.layout;

import org.remoteui.webapp.WebActivity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * 
 *
 * @author Daniel Thommes
 */
@Configuration
public class LayoutConfig {

	@Bean
	WebActivity tablelayout() {
		return createActivity("layout:tablelayout", "tablelayout.layout.xml");
	}
	@Bean
	WebActivity scrollview() {
		return createActivity("widget:scrollView", "scrollviews.layout.xml");
	}

	private WebActivity createActivity(String id, String layout) {
		return new WebActivity(id, new ClassPathResource(layout, getClass()));
	}
}
