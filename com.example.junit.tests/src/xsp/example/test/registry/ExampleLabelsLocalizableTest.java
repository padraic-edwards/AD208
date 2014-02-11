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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ibm.xsp.test.framework.registry.BaseLabelsLocalizableTest;

public class ExampleLabelsLocalizableTest extends BaseLabelsLocalizableTest {
	
	// Custom mainHeader property to localize
    private String[] extendListLocalizableNames = new String[]{
            "mainHeader"
    };
	
	protected List<String> getCommonLocalizableNames() {
		List<String> commonListLocalizableNames=super.getCommonLocalizableNames();
		
		List<String> combinedList = new ArrayList<String>();
		combinedList.addAll(Arrays.asList((String[])commonListLocalizableNames.toArray()));
		combinedList.addAll(Arrays.asList(extendListLocalizableNames));
		
		return combinedList;
	}	
}
