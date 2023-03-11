Feature: Demosauce Login
	
	#Declarative Programming
  Scenario: Test invalid login to DemoSauce
    Given User has accessed demosauce site
    When User input username "standard_user"
    And User input invalid password "salahehsalah"
    And Click on login button
    Then Validation message will be displayed
    
  Scenario: Test login to DemoSauce
    Given User has accessed demosauce site
    When User input username "standard_user"
    And User input password "secret_sauce"
    And Click on login button
    Then Validate homepage is displayed