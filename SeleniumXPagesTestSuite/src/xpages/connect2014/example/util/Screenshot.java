/*
 * © Copyright IBM Corp. 2012
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
package xpages.connect2014.example.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.TestListenerAdapter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.testng.ITestResult;
import org.testng.Reporter;

import xpages.connect2014.example.Connect2014Example;


public class Screenshot extends TestListenerAdapter {
	
    private String baseFolderName = "XPagesSeleniumTestSuite";
    private String scheenshotFolder = "\\test-output\\Screenshots\\";
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmm-SSS");
    
    /**
     * This is called when a test fails. It records a screenshot of the browser contents
     * (note, the screenshot doesnt include the entire screen of the machine, just the
     * browser window's contents). 
     */
	@Override
	public void onTestFailure(ITestResult result) {		
		//Get the users working directory 
		String userHome = System.getProperty("user.dir");
		
		//Append the screenshots folder destination
		String screenShotsFolder = userHome + scheenshotFolder; 
		
		//Retrieve the test method name
		String testMethod =	result.getMethod().getMethodName() ;//+ "(" + result.getTestClass().getName() + ")"; 
		
		//Format the time and add it to the filename so it is unique
		Calendar cal = Calendar.getInstance();
		
		//Create the filename and path from the Strings above
		String filename = testMethod + "-" + sdf.format(cal.getTime()) + ".png"; 
		String filepath = screenShotsFolder + filename;
		File file = new File(filepath);
		
		//Add a link to the screenshot into the html report
		Reporter.setCurrentTestResult(result);	 
		Reporter.log("Error screenshot: ");
		Reporter.log("<a href='"+file.getAbsolutePath()+"'>"+filename+"</a>\n");
		
		//Create the screenshot file
		File scrFile = ((TakesScreenshot)Connect2014Example.webDriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Reporter.setCurrentTestResult(null);
		
		Connect2014Example.webDriver.close();
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
	// will be called after test will be skipped
	}
	 
	@Override
	public void onTestSuccess(ITestResult result) {
	// will be called after test will pass
	}
	
	/**
	 * A static method that can be used to log screenshots at any time, not just on test failures
	 */
	public void captureScreenshot() {		
		//Get the users working directory and remove exltib folders from it
		String userHome = System.getProperty("user.dir");
		String userWorkspace = userHome.substring(0, (userHome.indexOf(baseFolderName)+baseFolderName.length()));
		
		//Append the screenshots folder destination
		String screenShotsFolder = userWorkspace + scheenshotFolder; 
		
		//Format the time and add it to the filename so it is unique
		Calendar cal = Calendar.getInstance();		
		
		//Create the filename and path from the Strings above
		String filename = "SoftAssertError-" + sdf.format(cal.getTime()) + ".png"; 
		String filepath = screenShotsFolder + filename;
		File file = new File(filepath);
		
		//Add a link to the screenshot into the html report
		Reporter.log("Error screenshot: ");
		Reporter.log("<a href='"+file.getAbsolutePath()+"'>"+filename+"</a>\n");
		
		//Create the screenshot file
		File scrFile = ((TakesScreenshot)Connect2014Example.webDriver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
 
