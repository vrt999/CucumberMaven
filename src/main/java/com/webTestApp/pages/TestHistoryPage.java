package com.webTestApp.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestHistoryPage extends BasePage {
	
	public TestHistoryPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//tbody[@id = 'historyBody']//tr[1]//td[1]")
	WebElement latestTestEntry;

	public void validateRecentTestHistortyEntry(String url) {
		try{
			if(!latestTestEntry.isDisplayed())
				System.out.println("No entries are displayed in the Test History grid");
			else if(latestTestEntry.getText().contains(url)){
				System.out.println("The latest entry is same as the triggered url");
			}
		}
		catch(Exception e){
			
		}
	}

}
