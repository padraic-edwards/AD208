/*
 * © Copyright IBM Corp. 2014
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */ 
package xsp.example.test.setup;

import xsp.example.test.ExampleTestSuite;

import com.ibm.xsp.test.framework.setup.BaseSuiteSetupTest;

public class ExampleSuiteSetupTest extends BaseSuiteSetupTest {
	
	@Override
	protected long getTestedSuiteVersion() {
		return ExampleTestSuite.SUITE_VERSION;
	}

	@Override
	protected String getTestedSuiteName() {
		return "ExampleTestSuite";
	}
}
