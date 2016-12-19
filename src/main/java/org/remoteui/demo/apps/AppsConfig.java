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
package org.remoteui.demo.apps;

import org.remoteui.demo.BaseDemoConfig;
import org.remoteui.webapp.WebActivity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Static activities for the "apps" category of th demo
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
