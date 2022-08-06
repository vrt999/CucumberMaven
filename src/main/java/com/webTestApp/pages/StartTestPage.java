package com.webTestApp.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartTestPage extends BasePage {
	
	WebDriver driver;
	
	public static List<String> expectedTestNames = Arrays.asList("Core Web Vitals","Lighthouse","Visual Comparison","Traceroute");
	
	private String testUrl;
	
	public StartTestPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[contains(@class,'wptheader-current')]//span")
	WebElement landingPageTab;
	
	@FindBy(xpath = "//span[@class = 'home_test_select_label']")
	WebElement defaultTest;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Enter a website URL')]")
	WebElement enterTestURL;
	
	@FindBy(xpath = "//span[@class = 'home_test_select']")
	WebElement testDropDown;
	
	@FindBy(xpath = "//span[@class = 'home_test_select']//a")
	List<WebElement> testDropDownOptions;
	
	@FindBy(className = "start_test")
	WebElement startTest;
	
	@FindBy(xpath = "//ul[@class = 'runningStatusIndicator']//li[@class= 'is-active']")
	WebElement currentTestStatus;
	
	@FindBy(xpath = "//p[@class = 'runningDetails']//a")
	WebElement testURLTriggered;
	
	@FindBy(xpath = "//h1[text()='Webpage Performance Test Result']")
	WebElement performanceResult;

	public void verifyLandingPage() {
		try {
		String currentTabText = landingPageTab.getText();
		if(currentTabText.contentEquals("Start Test")) {
			System.out.println("The landing page of the application is as expected: "+ currentTabText);
		}
		else {
			System.out.println("The Landing page of the application isnot as expected: "+ currentTabText);
		}
		}
		catch(Exception e) {
			System.out.println("The exception occured while verifying the landing page - "+ e.getMessage());
		}
		
	}
	
	

	public void verifyTestDropdownOptions() {
		try {
		testDropDown.click();
		List<String> actualTestNames = new ArrayList<>();
		testDropDownOptions.forEach(x->{actualTestNames.add(x.getText());});
		if(expectedTestNames.equals(actualTestNames)) {
			System.out.println("The test dropdown options are as expected: "+ actualTestNames);
		}
		else {
			System.out.println("The test dropdown options aren't as expected: "+ actualTestNames);
		}
		}
		catch(Exception e) {
			System.out.println("The exception occured while verifying test dropdown options - "+ e.getMessage());
		}
	}



	public void verifyDefaultTestDispayed() {
		try {
		String defaultTestName = defaultTest.getText();
		
		if(defaultTestName.contentEquals("Site Performance")) {
			System.out.println("The default test name is as expected: "+ defaultTestName);
		}
		else {
			System.out.println("The default test name isnot as expected: "+ defaultTestName);						
		}	
	}
	catch(Exception e) {
		System.out.println("The exception occured while verifying the default test name - "+ e.getMessage());
	}
		
	}



	public void enterTestUrLAndTriggerTest(String testURL) {
		try {
			testUrl = testURL;
			enterTestURL.sendKeys(testURL);
			startTest.click();
		}
		catch(Exception e) {
			System.out.println("The exception occured while triggering the test - "+ e.getMessage());
		}
		
	}



	public void verifyTestProgressPage() {
		try {
			if(isElementPresent(currentTestStatus,30)) {
			String actualTestURL = testURLTriggered.getAttribute("href");
			if(!actualTestURL.contains(testUrl)) {
				Assert.fail("The test triggered for an incorrect url: " + actualTestURL);
			}
			String currentStatus = currentTestStatus.getText();
			System.out.println("The current test status: "+ currentStatus);
			}
			else {
				System.out.println("Unable to find the triggered current test status");
			}
		}
		catch(Exception e) {
			System.out.println("The exception occured while verifying the page navigation after test trigger - "+ e.getMessage());
		}
		
	}



	public void verifyPeformanceResultPageVisibility() {
		try {
			if(isElementPresent(performanceResult, 60)) {
				System.out.println("The Performance Result page is displayed with in 60 secs");
			}
			else {
				System.out.println("The Performance Result page isnot displayed with in 60 secs");
			}
		}
		catch(Exception e) {
			System.out.println("The exception occured while verifying Peformance Result Page Visibility - "+ e.getMessage());
		}
		
	}



	
	

}
