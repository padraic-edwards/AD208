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
package xpages.connect2014.example;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

@SuppressWarnings("unused")
public class Connect2014Example {

	//Server & Application paths
	private String server = "http:\\[serveraddress]";
	private String application = "\\discuss.nsf";	//location of discuss.nsf on the server
	
	//WebDriver object
	public static WebDriver webDriver;
	
	public void launchTest() {
	    //Create Chromedriver
		//Mandatory setting - set the path to the Chrome driver before we create it
	    //System.setProperty("webdriver.chrome.driver", "Selenium\\chromedriver.exe");
	    //Set the browser to open as maximised
	    //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized");
        //Create the ChromeDriver using the ChromeOptions object
        //webDriver = new ChromeDriver(options);

        //Create FirefoxDriver
        //Comment out the line below, and uncomment the ChromeDriver lines above in order to run tests in Google Chrome
        webDriver = new FirefoxDriver();
        
        //Set how long to wait for an element to appear
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        //Load the XPage
        webDriver.get(server+application);
	}
	
	@Test(description="Test the homepage")
    public void testVerifyHomePage() {
		launchTest();
		
        //Get the image's src value
        String imgSrc = getImage_home_splash().getAttribute("src");
        //Get the image's src value
        String headerText = getText_header().getText();

        //Verify the results are as expected
        String expectedImg = "homepage1.png";
        String expectedHeader = "Connect 2014 Demo App";
        assert(imgSrc.contains(expectedImg)):"Verify homepage image is '" + expectedImg + "'. Found: '" + imgSrc + "'.";
        assert(headerText.equals(expectedHeader)):"Verify homepage header is '" + expectedHeader + "'. Found: '" + headerText + "'.";
    }
	
	@Test(description="Test the creation of a document")
    public void testCreateDoc() {
        webDriver.get(server+application);
        
	    //Data values for the document
	    String title = "DocumentTest1";
	    String body = "This is the body text of a document";
	    String attachment = System.getProperty("user.dir") + "\\Resources\\textDoc.txt";
	    
	    //Click the new document button
	    getButton_header_newDoc().click();
	    
	    //Enter the document data
	    getInput_newDoc_title().sendKeys(title);
        getInput_newDoc_body().sendKeys(body);
        getInput_newDoc_attachment().sendKeys(attachment);
        
        //Click the save button
        getButton_newDoc_save().click();
        
        //Open the all documents view
        getLink_menu_allDocs().click();
        
        //Verify the result is as expected
        String allDocsTitle = getLink_allDocs_title(0).getText();
        String allDocsSummary = getText_allDocs_body(0).getText();
        assert(allDocsTitle.equals(title)) : "Verify created document title: '" + title + "'. Found: '" + allDocsTitle + "'.";
        assert(allDocsSummary.equals(body)) : "Verify created document body: '" + body + "'. Found: '" + allDocsSummary + "'.";
    }
	
	@Test(description="Verify the created document", dependsOnMethods="testCreateDoc")
    public void testVerifyDoc() {
        webDriver.get(server+application);
        
        //Data values for the document
        String actualTitle = "DocumentTest1";
        String actualBody = "This is the body text of a document";
        String actualAttachment = "textDoc.txt";
        
        //Open the all documents view
        getLink_menu_allDocs().click();
        
        //Open the relevant document
        getLink_allDocs_title(actualTitle).click();
        
        //Verify the document data
        String foundTitle = getInput_openDoc_title().getText();
        String foundBody = getInput_openDoc_summary().getText();
        String foundAttachment = getInput_openDoc_attachment().getText();
        assert(foundTitle.equals(actualTitle)) : "Verify created document title: '" + actualTitle + "'. Found: '" + foundTitle + "'.";
        assert(foundBody.equals(actualBody)) : "Verify created document body: '" + actualBody + "'. Found: '" + foundBody + "'.";
        assert(foundAttachment.equals(actualAttachment)) : "Verify created document attachment: '" + actualAttachment + "'. Found: '" + foundAttachment + "'.";
        
        //Delete the document
        getButton_openDoc_delete().click();

		//Close webdriver
		webDriver.close();
    }
	
	/*
	 * All of the WebElement locator methods for the application
	 */
	
	private WebElement getLink_menu_allDocs() {
	    return webDriver.findElement(By.xpath("//div[contains(@id, 'form1:menuLeft')]//a[contains(., 'All Documents')]"));
    }
	private WebElement getButton_header_newDoc() {
        return webDriver.findElement(By.cssSelector("div[id='view:ccLayout:form1:appLayout1_pb'] span[class='lotusBtn'] a"));
    }
	private WebElement getImage_home_splash() {
        return webDriver.findElement(By.cssSelector("img[id='view:ccLayout:form1:callback1:homeSplash']"));
    }
	private WebElement getText_header() {
        return webDriver.findElement(By.xpath("//h2[contains(@id, 'form1:appLayout1_pbName')]"));
    }
	private WebElement getButton_newDoc_save() {
        return webDriver.findElement(By.cssSelector("button[id='view:ccLayoutNew:form1:callback1:saveBtn']"));
    }
	private WebElement getInput_newDoc_title() {
        return webDriver.findElement(By.cssSelector("input[id='view:ccLayoutNew:form1:callback1:titleInput']"));
    }
	private WebElement getInput_newDoc_body() {
        return webDriver.findElement(By.cssSelector("textarea[id='view:ccLayoutNew:form1:callback1:summaryInput']"));
    }
	private WebElement getInput_newDoc_attachment() {
        return webDriver.findElement(By.cssSelector("input[id='view:ccLayoutNew:form1:callback1:fileUpload1']"));
    }
	private WebElement getInput_openDoc_title() {
        return webDriver.findElement(By.cssSelector("span[id='view:ccLayoutNew:form1:callback1:titleInput']"));
    }
    private WebElement getInput_openDoc_summary() {
        return webDriver.findElement(By.cssSelector("span[id='view:ccLayoutNew:form1:callback1:summaryInput']"));
    }
    private WebElement getInput_openDoc_attachment() {
        return webDriver.findElement(By.xpath("//table[@id='view:ccLayoutNew:form1:callback1:fileDownload1']//tr/td[3]/a/span"));
    }
    private WebElement getLink_allDocs_title(int index){
        return webDriver.findElement(By.cssSelector("a[id='view:ccLayoutAll:form1:callback1:allDocsDataView:"+ index +"_sumLink']"));
    }
    private WebElement getLink_allDocs_title(String title){
        return webDriver.findElement(By.linkText(title));
    }
    private WebElement getText_allDocs_body(int index){
        return webDriver.findElement(By.cssSelector("span[id='view:ccLayoutAll:form1:callback1:allDocsDataView:"+ index +":bodyValue']"));
    }
	private WebElement getButton_openDoc_delete() {
        return webDriver.findElement(By.cssSelector("button[id$='deleteBtn']"));
    }
}