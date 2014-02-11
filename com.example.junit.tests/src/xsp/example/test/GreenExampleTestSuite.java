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
package xsp.example.test;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.ibm.xsp.test.framework.TestClassList;
import com.ibm.xsp.test.framework.setup.SkipFileTestSetup;
import com.ibm.xsp.test.framework.setup.SkipFileUsedTest;

public class GreenExampleTestSuite extends TestSuite {

	public static Test suite() { 
        ExampleTestSuite mainSuite = new ExampleTestSuite();
        List<Class<?>> testClasses = ExampleTestSuite.getTestClassList();
        // if necessary replace a class with a green subclass (that will always pass), like so:
        // testClasses.set(testClasses.indexOf(RegisteredDecodeTest.class), GreenRegisteredDecodeTest.class);

        TestClassList.addAll(mainSuite, testClasses);
        GreenExampleTestSuite greenSuite = new GreenExampleTestSuite();
        greenSuite.addTest(new SkipFileTestSetup(mainSuite,"junit-results.txt"));
        greenSuite.addTestSuite(SkipFileUsedTest.class);
        return greenSuite;
    }

    public static void main(String args[]) { 
        junit.textui.TestRunner.run(suite());
    }
}
