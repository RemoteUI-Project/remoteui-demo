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
package org.remoteui.demo.apps.calculator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

import org.remoteui.annotation.Activity;
import org.remoteui.webapp.WebActivity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Example "app" - a scientific calculator.
 * 
 * @author Daniel Thommes
 */
@Activity(id = "scientificCalc", layout = "calculator.layout.mv")
public class ScientificCalculatorActivity extends WebActivity {

	/**
	 * SLF4J Logger
	 */
	private static final Logger logger = LoggerFactory
			.getLogger(ScientificCalculatorActivity.class);

	private Evaluator evaluator = new Evaluator();

	private String calculation = "";

	private String ans = "";

	private static Map<Pattern, String> patterns = new LinkedHashMap<Pattern, String>();

	static {
		patterns.put(Pattern.compile("e"), "2.718281828459045");
		patterns.put(Pattern.compile("π"), "(2*asin(1))");
		patterns.put(Pattern.compile("√(-?\\d+\\.?\\d*)"), "sqrt($1)");
		patterns.put(Pattern.compile("sin(-?\\d+\\.?\\d*)"), "sin($1)");
		patterns.put(Pattern.compile("asin(-?\\d+\\.?\\d*)"), "asin($1)");
		patterns.put(Pattern.compile("cos(-?\\d+\\.?\\d*)"), "cos($1)");
		patterns.put(Pattern.compile("acos(-?\\d+\\.?\\d*)"), "acos($1)");
		patterns.put(Pattern.compile("tan(-?\\d+\\.?\\d*)"), "tan($1)");
		patterns.put(Pattern.compile("atan(-?\\d+\\.?\\d*)"), "atan($1)");
		// log y = ln y / ln 10
		patterns.put(Pattern.compile("log(-?\\d+\\.?\\d*)"), "log($1)/log(10)");
		patterns.put(Pattern.compile("ld(-?\\d+\\.?\\d*)"), "log($1)/log(2)");
		patterns.put(Pattern.compile("ln(-?\\d+\\.?\\d*)"), "log($1)");
		patterns.put(Pattern.compile("E(-?\\d+\\.?\\d*)"), "*10^$1");
		patterns.put(Pattern.compile("²"), "^2");
		patterns.put(Pattern.compile("³"), "^3");
		patterns.put(Pattern.compile("(-?\\d+\\.?\\d*)\\^(-?\\d+\\.?\\d*)"), "pow($1,$2)");
		patterns.put(Pattern.compile("x"), "*");
	}

	public String getCalculation() {
		return calculation;
	}

	public void append(String text) {
		calculation += text;
		firePropertyChanged("calculation");
	}

	public void onAcClicked() {
		calculation = "";
		firePropertyChanged("calculation");
	}

	public void onBackSpace() {
		if (calculation.length() > 0) {
			calculation = calculation.substring(0, calculation.length() - 1);
			firePropertyChanged("calculation");
		}
	}

	public void onAnsClicked() {
		calculation += ans;
		firePropertyChanged("calculation");
	}

	public void onEvaluate() {
		try {
			for (Entry<Pattern, String> replacement : patterns.entrySet()) {
				Matcher matcher = replacement.getKey().matcher(calculation);
				if (matcher.find()) {
					calculation = matcher.replaceAll(replacement.getValue());
				}
			}
			logger.debug("{}", calculation);
			calculation = evaluator.evaluate(calculation);
			ans = calculation;
		} catch (EvaluationException e) {
			calculation = e.getMessage();
		}
		firePropertyChanged("calculation");
	}
}
