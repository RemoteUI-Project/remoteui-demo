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
package org.remoteui.demo.ui;

import org.remoteui.demo.BaseDemoConfig;
import org.remoteui.webapp.WebActivity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring config for the static UI activities
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
