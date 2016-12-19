/** 
* Created on 25.11.2016 
* 
* © 2016 Daniel Thommes
*/
package org.remoteui.demo.apps.contacts;

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
public class ContactsConfig {

	@Bean
	WebActivity contactsDetailActivity() {
		return new WebActivity("contactsDetail",
				new ClassPathResource("contacts-detail.layout.mv", ContactsConfig.class));
	}

	@Bean
	WebActivity contactsNewActivity() {
		return new WebActivity("contactsNew",
				new ClassPathResource("contacts-new.layout.mv", ContactsConfig.class));
	}

}
