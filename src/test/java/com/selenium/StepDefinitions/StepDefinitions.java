package com.selenium.StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.webTestApp.pages.StartTestPage;
import com.webTestApp.pages.TestHistoryPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions {
	
	WebDriver driver;
	StartTestPage stp;
	TestHistoryPage th;
	String url;
	
	@Before(order=1)
    public void beforeScenario(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\crazy\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
	    driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }	
	@Before(order=0)
    public void beforeScenarioStart(){
        System.out.println("-----------------Start of Scenario-----------------");
    }	
	
	
	@After(order=0)
    public void afterScenarioFinish(){
        System.out.println("-----------------End of Scenario-----------------");
    }	
	@After(order=1)
    public void afterScenario(){
        System.out.println("Log out the user and close the browser");
        // code to logout if user is logged in
        driver.quit();
    }
	
	@Given("User launches the application")
	public void user_launches_the_application() {
		driver.get("https://www.webpagetest.org");	    
	}

	@Then("User verifies if the landing page is start test page")
	public void user_verifies_if_the_landing_page_is_start_test_page() {
		 stp = new StartTestPage(driver);
	     stp.verifyLandingPage();	      
	}
	
	@And("User verifies if all the required test options are available")
	public void user_verifies_if_all_the_required_test_options_are_available() {
		  stp.verifyDefaultTestDispayed();
	      stp.verifyTestDropdownOptions();	      
	}

	@When("User provides the {string} and triggers the performance test")
	public void user_provides_the_and_triggers_the_performance_test(String testURL) {
			url = testURL;
	      stp.enterTestUrLAndTriggerTest(testURL);
	      
	}

	@Then("User should be navigated to test in progress page")
	public void user_should_be_navigated_to_test_in_progress_page() {
	      stp.verifyTestProgressPage();
	      
	}

	@Then("User verifies if the performance result page is displayed once the test is complete")
	public void user_verifies_if_the_performance_result_page_is_displayed_once_the_test_is_complete() {
	      stp.verifyPeformanceResultPageVisibility();
	      
	}

	@Then("User verifies if the test triggered is available under the test history")
	public void user_verifies_if_the_test_triggered_is_available_under_the_test_history() {
	      stp.navigateToPage("Test History");
	      th = new TestHistoryPage(driver);
	      th.validateRecentTestHistortyEntry(url);
	      
	}

	@Then("User verifies that the test can be cancelled if wait time is more than {string} seconds")
	public void user_verifies_that_the_test_can_be_cancelled_if_wait_time_is_more_than_seconds(String string) {
	      
	      
	}

	@Then("User navigates to the test history page")
	public void user_navigates_to_the_test_history_page() {
	      
	      
	}

	@When("User clicks on compare without test selection")
	public void user_clicks_on_compare_without_test_selection() {
	      
	      
	}

	@Then("User should be displayed with a valid message")
	public void user_should_be_displayed_with_a_valid_message() {
	      
	      
	}

	@When("User searches for the {string}")
	public void user_searches_for_the(String string) {
	      
	      
	}

	@Then("User should be displayed with the appropriate filtered results")
	public void user_should_be_displayed_with_the_appropriate_filtered_results() {
	      
	      
	}

	@Then("User selects the tests of the {string} required and perform the comparison of the results")
	public void user_selects_the_tests_of_the_required_and_perform_the_comparison_of_the_results(String string) {
	      
	      
	}

}
