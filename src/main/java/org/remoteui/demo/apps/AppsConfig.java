/** 
* Created on 25.11.2016 
* 
* © 2016 Daniel Thommes
*/
package org.remoteui.demo.apps;

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
public class AppsConfig extends BaseDemoConfig {

	@Bean
	public WebActivity clientinfo() {
		return createActivity("clientInfo", "clientinfo/clientInfo.layout.mv", getClass());
	}
}
