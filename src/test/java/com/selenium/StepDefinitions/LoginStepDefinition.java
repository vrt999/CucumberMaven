package com.selenium.StepDefinitions;

import java.util.List;
import java.util.Map;
//import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	
	WebDriver driver;
	
	@Given("open chrome and run application")
	public void open_chrome_and_run_application() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\crazy\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-features=VizDisplayCompositor");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://facebook.com");		
		
		System.out.println("Step 1 is executed successfully");
	}
	// steps for examples scenario
	@When("I enter valid {string} and {string}")
	public void i_enter_valid_username_and_password(String user,String password) {
		driver.findElement(By.cssSelector("input[name = 'email']")).sendKeys(user);
		driver.findElement(By.cssSelector("input[name = 'pass']")).sendKeys(password);
		System.out.println("Step 2 is executed successfully");}
		
		// steps for data table scenario
		@When("^I enter valid username and password$")
		public void i_enter_valid_username_and_password1(DataTable credentials) {
			List<Map<String,String>> l = credentials.asMaps(String.class, String.class);			
			driver.findElement(By.cssSelector("input[name = 'email']")).sendKeys(l.get(0).get("username"));
			driver.findElement(By.cssSelector("input[name = 'pass']")).sendKeys(l.get(0).get("password"));			
		}
	
	// steps for data table for maps scenario
	/*
	 * @When("^I enter valid username and password$") public void
	 * i_enter_valid_username_and_password1(DataTable credentials) {
	 * List<List<String>> l = credentials.cells();
	 * driver.findElement(By.cssSelector("input[name = 'email']")).sendKeys(l.get(0)
	 * .get(0));
	 * driver.findElement(By.cssSelector("input[name = 'pass']")).sendKeys(l.get(0).
	 * get(1));
	 * 
	 * 
	 * }
	 */
		@Given("I navigate to the login page")
		public void i_navigate_to_the_login_page() {
		    // Write code here that turns the phrase above into concrete actions
		    System.out.println("Back ground step - naviagte to login page");
		}

		
		  @When("I submit username and password") public void
		  i_submit_username_and_password(DataTable credentials) { 
			  List<List<String>> l = credentials.cells();
			  // Write code here that turns the phrase above into concrete actions
		  System.out.println("Back ground step - submit user name:"+l.get(0).get(0)+" and password:"+l.get(0).get(1)); }
		 

		@Then("I should be logged in")
		public void i_should_be_logged_in() {
		    // Write code here that turns the phrase above into concrete actions
			System.out.println("Back ground step - User should be loggedin");
		}

	//step definition doesn't support method over loading.Always the method name should be unique

	@Then("User should be loggedin successfully")
	public void user_should_be_loggedin_successfully() {
		driver.findElement(By.cssSelector("button[type = 'submit']")).click();
		System.out.println("Step 3 is executed successfully");
		System.out.println("Develop updated");

	}

	@Then("User should be loggedin successfullymaster updated")
	public void user_should_be_loggedin_develop_master() {
		driver.findElement(By.cssSelector("button[type = 'submit']")).click();
		System.out.println("Step 3 is executed successfully commit from develop and master");

	}

	@Then("User should be loggedin successfully new develop updated")
	public void user_should_be_loggedin_develop_master_new() {
		driver.findElement(By.cssSelector("button[type = 'submit']")).click();
		System.out.println("Step 3 is executed successfully commit from develop");
		System.out.println("Step 3 is executed successfully master rebase on develop and forward from master");
		System.out.println("Step 4 is added from develop");
		System.out.println("Step 5 is added from master");

	}

}
