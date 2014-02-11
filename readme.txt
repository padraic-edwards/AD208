These materials were used as part of the Automated GUI testing & JUnit demonstrations during session AD208 of IBM Connect 2014. 
For the accompanying slide deck of AD208, see: http://www.slideshare.net/beglee/ad208-end-to-end-quality-processes-for-top-notch-xpages-apps

Setup and install instructions:

1. The discuss.nsf demo app was created for the Automated GUI testing section of the AD208 presentation. It is used by the Selenium test project, described below, to demonstrate Automated GUI testing
	
	- Add discuss.nsf to your server's data directory
	- Sign the nsf in Domino Administrator
	- Open the nsf in a browser to verify it is working correctly

2. Selenium Automated GUI Project

	- Copy/unzip the SeleniumXPagesTestSuite project to your machine
	- Download the latest Selenium jar files from: https://code.google.com/p/selenium/downloads/list 
	- Unzip the Selenium jar files to your machine
	- OPTIONAL: Download the latest chromedriver.exe if you wish to run Selenium tests in Google Chrome: http://chromedriver.storage.googleapis.com/index.html
	- Import the SeleniumXPagesTestSuite project to Eclipse/IBM Domino Designer
	- In Eclipse/Designer, add the Selenium jar files to the "build path" of the SeleniumXPagesTestSuite project
	- Also add all of the jar files in the "lib" folder of the Selenium install to the build path of the project
	- Install the TestNG plugin to Eclipse/Designer: http://testng.org/doc/download.html
	- Change lines 32 & 33 of Connect2014Example.java to point to your server and app locations
	- OPTIONAL: On line 41 of Connect2014Example.java, set the location of chromedriver on your system
	- Create a TestNG run configuration, see TestNG site for documentation

3. The following plugins were created for the JUnit section of the AD208 presentation. The first is an example XPage library containing one control. This is the control we are testing with the second plugin which is a set of JUnit tests built to run with the XPages JUnit Framework which can be found in every OpenNTF release. These JUnit tests were built to run with the latest JUnit framework. 

	- com.example.xsp
	- com.example.junit.tests 

Associated articles that describe how to create these plugins can be found here
	- http://www-10.lotus.com/ldd/ddwiki.nsf/dx/Testing_XPages_with_JUnit_Test_Framework
	- http://www-10.lotus.com/ldd/ddwiki.nsf/dx/Testing_XPagescol_Quick_Start