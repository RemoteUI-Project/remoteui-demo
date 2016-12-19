package org.remoteui.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class RemoteuiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemoteuiDemoApplication.class, args);
	}

	/**
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
