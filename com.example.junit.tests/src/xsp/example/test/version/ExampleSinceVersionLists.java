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
package xsp.example.test.version;

import java.util.ArrayList;
import java.util.List;

import com.ibm.xsp.test.framework.version.SinceVersionList;

public class ExampleSinceVersionLists {
	
	public static List<SinceVersionList> getSinceVersionLists(){
        List<SinceVersionList> list = new ArrayList<SinceVersionList>();
        list.add(new Example100List());

        return list;
    }

	public static class Example100List implements SinceVersionList {
        private Object[][] tagsAndProps = new Object[][]{
                // new Object[]{"prefixedTagName", newTagThisVersion, new String[]{
                //    "propName",
                //    "propName",
                // }},
        		new Object[]{"eg:exampleControl", true, new String[]{
        				"mainHeader",
        				"title",
        			}},

        };
        private String[] skips = new String[]{
        };
        public Object[][] tagsAndProps() {
            return tagsAndProps;
        }
        public String sinceVersion() {
            return "1.0.0";
        }
        public String[] skips() {
            return skips;
        }
    }
}
