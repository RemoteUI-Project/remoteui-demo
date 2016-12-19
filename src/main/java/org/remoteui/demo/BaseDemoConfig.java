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

import org.remoteui.webapp.WebActivity;
import org.springframework.core.io.ClassPathResource;

/**
 * Base class for the Spring configurations in this app
 *
 * @author Daniel Thommes
 */
public class BaseDemoConfig {

	protected WebActivity createActivity(String id, String layout,
			Class<? extends BaseDemoConfig> clazz) {
		return new WebActivity(id, new ClassPathResource(layout, clazz));
	}
}
