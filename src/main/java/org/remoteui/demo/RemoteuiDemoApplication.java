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
package org.remoteui.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * This is the Spring Boot application that starts the Spring container and the
 * Tomcat webserver for you.
 *
 * @author Daniel Thommes
 */
@SpringBootApplication
public class RemoteuiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemoteuiDemoApplication.class, args);
	}

	/**
	 * The internationalization is done with Spring's MessageSource which has to
	 * be present in the the context.
	 * 
	 * With Spring Boot the bean has to be named exactly like this, otherwise,
	 * Spring Boot won't autoconfigure it correctly.
	 * 
	 * @return
	 */
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("locale/messages");
		messageSource.setFallbackToSystemLocale(false);
		return messageSource;
	}
}
