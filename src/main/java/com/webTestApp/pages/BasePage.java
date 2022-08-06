package com.webTestApp.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a/span[text()='Test History']")
	WebElement testHistoryBtn;

	// keep some common UI elements,methods like drop down selections,clicks,waits
	// etc

	public boolean isElementPresent(WebElement e, int timeout) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
			WebElement e1 = wait.until(ExpectedConditions.visibilityOf(e));
			return e1.isDisplayed();
		}
		catch (Exception exp) {
			System.out.println(
					"The exception occured while verifying the page navigation after test trigger - " + exp.getMessage());
		}
		return false;
	}
	

	public void navigateToPage(String pageName) {		
		try {
			WebElement pageNameBtn = driver.findElement(By.xpath("//a/span[text()='"+pageName+"']"));
			pageNameBtn.click();
			WebElement currentPageName = driver.findElement(By.xpath("//h1[text()='"+pageName+"']"));
			if(isElementPresent(currentPageName, 5)) {
				System.out.println(pageName + " is opened successfully");
			}
			else {
				System.out.println("Unable to navigate to page: "+ pageName);
			}
		}
		catch (Exception exp) {
			System.out.println(
					"The exception occured while verifying the page navigation to page: "+ pageName+"  -- " + exp.getMessage());
		}
		
	}

}
