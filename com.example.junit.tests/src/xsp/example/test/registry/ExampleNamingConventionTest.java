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
package xsp.example.test.registry;

import com.ibm.xsp.test.framework.registry.BaseNamingConventionTest;

public class ExampleNamingConventionTest extends BaseNamingConventionTest {
	@Override
	protected boolean isRequireControlSubpackageName() {
		return false;
	}
	
	@Override
	protected String[] getExpectedPrefixes() {
		String[] expectedPrefixes = super.getExpectedPrefixes();
		// [0] package-name prefix
		//"com.ibm.xsp",
//		expectedPrefixes[0] = "com.ibm.xsp.extlib";
		// [1] abstract component package-name suffix: usually ".component"
		//".component",
//		expectedPrefixes[1] = ".component.+";
//		// [2] tag component package-name suffix: usually ".component" or "component.xp."
//		//".component.xp",
		expectedPrefixes[2] = ".component";
//		 [4] tag component short java-class prefix: usually "Xsp"
//		"Xsp",
		expectedPrefixes[4] = ""; 
//        // [5] abstract component short java-class suffix: possibly "Ex" or "Ex2"
//        expectedPrefixes[5]  = "Base";
//		// [7] abstract component-type short-name prefix: usually "UI"
//		//"UI",
//		expectedPrefixes[7] = "";
		
		return expectedPrefixes;
	} 

}
