These materials were used as part of the Automated GUI testing & JUnit demonstrations during session AD208 of IBM Connect 2014. 
For the accompanying slide deck of AD208, see: http://www.slideshare.net/beglee/ad208-end-to-end-quality-processes-for-top-notch-xpages-apps

Setup and install instructions:

1. The discuss.nsf demo app was created for the Automated GUI testing section of the AD208 presentation. It is used by the Selenium test project, described below, to demonstrate Automated GUI testing
	
	- Add discuss.nsf to your server's data directory
	- Sign the nsf in Domino Administrator
	- Open the nsf in a browser to verify it is working correctly. There are 3 pages in the app
		- Home page, which displays an image of Slide 1 of AD208.
		- All documents page, which displays a list of documents created in the app.
		- New document page, for creating new documents.

2. Selenium Automated GUI Project

	- Copy/unzip the SeleniumXPagesTestSuite project to your machine.
	- Download the Selenium v2.39* jar files from: http://selenium-release.storage.googleapis.com/2.39/selenium-server-2.39.0.zip
	- Unzip the Selenium jar files to your machine, make a note of where you unzipped them. 
	- Import the SeleniumXPagesTestSuite project to Eclipse/IBM Domino Designer. It will contain errors until you complete the steps below
	- In Eclipse/Designer, add the Selenium jar files (that you unzipped on your machine) to the "build path" of the SeleniumXPagesTestSuite project
		- jar files: selenium-server-2.39.0.jar, selenium-server-2.39.0-srcs.jar, selenium-server-standalone-2.39.0.jar
	- Also add all of the jar files in the "lib" folder of the Selenium unzip, to the build path of the project
	- Install the TestNG plugin to Eclipse/Designer: http://testng.org/doc/download.html
	- Change lines 32 & 33 of Connect2014Example.java to point to your server and app locations
	- OPTIONAL: To use Chrome as the test browser instead of the default, Firefox:
		- Download the latest chromedriver and unzip it on your machine: http://chromedriver.storage.googleapis.com/index.html?path=2.9/
		- Uncomment line 41 of Connect2014Example.java, set the location of chromedriver on your system
		- Uncomment lines
	- Create a TestNG run configuration, see TestNG site for documentation

3. The following plugins were created for the JUnit section of the AD208 presentation. The first is an example XPage library containing one control. This is the control we are testing with the second plugin which is a set of JUnit tests built to run with the XPages JUnit Framework which can be found in every OpenNTF release. These JUnit tests were built to run with the latest JUnit framework. 

	- com.example.xsp
	- com.example.junit.tests 

Associated articles that describe how to create these plugins can be found here
	- http://www-10.lotus.com/ldd/ddwiki.nsf/dx/Testing_XPages_with_JUnit_Test_Framework
	- http://www-10.lotus.com/ldd/ddwiki.nsf/dx/Testing_XPagescol_Quick_Start


* For the demo of AD208, we used Selenium v2.39, Firefox v26 and Chrome v32. There is no guarantee that the automation demo will work with older/newer versions.