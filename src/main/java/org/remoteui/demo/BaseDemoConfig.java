/** 
* Created on 25.11.2016 
* 
* © 2016 Daniel Thommes
*/
package org.remoteui.demo;

import org.remoteui.webapp.WebActivity;
import org.springframework.core.io.ClassPathResource;

/**
 * 
 *
 * @author Daniel Thommes
 */
public class BaseDemoConfig {

	protected WebActivity createActivity(String id, String layout,
			Class<? extends BaseDemoConfig> clazz) {
		return new WebActivity(id, new ClassPathResource(layout, clazz));
	}
}
