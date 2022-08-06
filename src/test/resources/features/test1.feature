Feature: Test facebook login

  #Scenario: login postive test - format should be this when passing direct paraameters
  #Scenario Outline: login postive test
  #Given open chrome and run application
  #When I enter valid "usernamevalue" and "passwordvalue"
  #		When I enter valid "usernamevalue" and "passwordvalue"
  #Then User should be loggedin successfully
  Scenario Outline: login postive test - format should be this when passing direct paraameters
    Given open chrome and run application
    When I enter valid "<username>" and "<password>"
    Then User should be loggedin successfully

    Examples: 
      | username | password  |
      | vrt3     | password3 |
      | vrt4     | password4 |
