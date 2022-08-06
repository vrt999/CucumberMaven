@webPageTests
Feature: Application is able to do the performance test and compare the results of an online applications

Background:
	Given User launches the application
	And User logs in the application
		
Scenario Outline: Verify the user is able to verify the performance result and test history of the test triggered
    Then User verifies if the landing page is start test page
    And User verifies if all the required test options are available
    When User provides the "<testURL>" and triggers the performance test
    Then User should be navigated to test in progress page
    And User verifies if the performance result page is displayed once the test is complete
    And User verifies if the test triggered is available under the test history

	Examples:
		| testURL |
		| https://www.google.com |
		| https://www.facebook.com |


  Scenario Outline: Ensure user is able to cancel the test triggered if the waiting queue is more than "<waitTime>"
    Then User verifies if the landing page is start test page
    When User provides the "<testURL>" and triggers the performance test
    Then User should be navigated to test in progress page
    And User verifies that the test can be cancelled if wait time is more than "<waitTime>" seconds

   Examples: 
		| testURL 							 | waitTime |
		| https://www.google.com | 30 |
		
		Scenario: Ensure valid message is displayed when user tries to click compare tests without test selection
			Then User verifies if the landing page is start test page
    	And User navigates to the test history page
    	When User clicks on compare without test selection
    	Then User should be displayed with a valid message
    	
   Scenario Outline: Validation of the search functionality in test history page
			Then User verifies if the landing page is start test page
    	And User navigates to the test history page
    	When User searches for the "<testURL>"
    	Then User should be displayed with the appropriate filtered results
    	
   Examples:
		| testURL |
		| https://www.google.com |
		| https://www.facebook.com |
		
		
	Scenario Outline: Ensure user is able to compare the performance results of the online applications
		Then User verifies if the landing page is start test page
    And User navigates to the test history page
    And User selects the tests of the "<urls>" required and perform the comparison of the results
    Then User should be navigated to test in progress page
    And User verifies that the test can be cancelled if wait time is more than "<waitTime>" seconds

   Examples: 
		| urls 							 | 
		| https://www.google.com,https://www.facebook.com |