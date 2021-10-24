Feature: Facebook login test

#same as @beforeMethod in testNG - runs before every scenario
Background: User is Logged In
 Given I navigate to the login page
 When I submit username and password
 Then I should be logged in 

  #		Scenario: login postive test - format should be this when passing direct paraameters
  #Scenario Outline: login postive test
    #Given open chrome and run application
    #When I enter valid "<username>" and "<password>"
    #When I enter valid "vrt99999" and "vrt99999"
    #Then User should be loggedin successfully
    #Examples: 
      #| username | password |
      #| vrt1     | vrt1pass |
      #| vrt2     | vrt2pass |

  Scenario: login postive test  #format should be this when passing direct paraameters
    #Scenario Outline: login postive test
    Given open chrome and run application
    When I enter valid username and password
      | username | password |
      | vrt3     | vrt3pass |
    Then User should be loggedin successfully
#
  #Scenario: login postive test - format should be this when passing direct paarameters
    #Scenario Outline: login postive test
    #Given open chrome and run application
    #When I enter valid username and password
      #| username | password |
      #| vrt1     | vrt1pass |
      #| vrt2     | vrt2pass |
      #| vrt3     | vrt3pass |
    #Then User should be loggedin succeessfully
      #| username | password |
      #| vrt1     | vrt1pass |
      #| vrt2     | vrt2pass |
