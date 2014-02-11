/*
 * � Copyright IBM Corp. 2014
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


public class ExampleNamingConventionErrorTest extends
		ExampleNamingConventionTest {
	
	 @Override
	    public String getDescription() {
	        return super.getDescription() +" [ERROR severity only]";
	    }
	    @Override
	    protected int getRuleSeverityLevelCutoff() {
	        // only show Errors, not Warning and Info
	        return SEV_ERROR;
	    }

}
