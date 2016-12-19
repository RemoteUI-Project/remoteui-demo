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

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.remoteui.annotation.Activity;
import org.remoteui.webapp.WebActivity;
import org.springframework.context.i18n.LocaleContextHolder;

/**
 * Demonstrates the use of internationalization features. Please see
 * i18n.layout.mv and src/main/resources/messages*.properties as well.
 * 
 * @see https://docs.oracle.com/javase/tutorial/i18n/format/messageFormat.html
 * @see http
 *      ://docs.spring.io/spring/docs/current/spring-framework-reference/html
 *      /beans.html#context-functionality-messagesource
 *
 * @author Daniel Thommes
 */
@Activity(id = "framework:i18n", layout = "i18n.layout.mv")
public class I18nActivity extends WebActivity {

	private DateFormat dateFormat;
	private NumberFormat numberFormat;

	/**
	 * This method is called by the Spring container.
	 */
	@PostConstruct
	public void init() {
		// If you need the client's locale, you can load it via Spring's holder
		Locale locale = LocaleContextHolder.getLocale();
		dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		numberFormat = NumberFormat.getInstance(locale);
	}

	/**
	 * Example for dynamically loading a string from the resources.
	 * 
	 * @return
	 */
	public String getBoundString() {
		// getMessage methods are inherited from WebActivity
		return getMessage("i18n.boundString");
	}

	/**
	 * Example for formatting dynamically loaded date instances
	 * 
	 * @return
	 */
	public String getDateTime() {
		return dateFormat.format(new Date());
	}

	/**
	 * Example for formatting dynamically loaded number instances
	 * 
	 * @return
	 */
	public String getNumber() {
		return numberFormat.format(1003.14159265359);
	}
}
