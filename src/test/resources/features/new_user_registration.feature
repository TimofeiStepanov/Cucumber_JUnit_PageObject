Feature: Automation end2end tests   to verify users
          scenarios on 'http://automationexercise.com'
  As a new user
  I want to create an account on the webpage
  I want login to my account
  So that I can access the website's features

  Scenario: Registration new user
#    Given I am on HomePage
#    When  Verify that home page is visible successfully
#    Then  Click on 'Signup / Login' button
#    When Verify 'New User Signup!' is visible
#    Then Enter name
#    And  Enter e-mail address
#    When Verify that 'ENTER ACCOUNT INFORMATION' is visible
#    Then Title fill
#    And Verify: Name like Entered on previous page
#    And Verify: e-mail like Entered on previous page
#    And Enter Password
#    And Enter Date of birth
#    And Enter First name
#    And Enter Last name
#    And Enter Address
#    And Enter Country
#    And Enter State
#    And Enter City
#    And Enter Zipcode
#    And Enter Mobile Number
#    Then Click 'Create Account button'
#    When Verify that 'ACCOUNT CREATED!' is visible
#    Then Click 'Continue' button
#    When  Verify that 'Logged in as username' is visible
#    Then Click 'Delete Account' button
#    When Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
#    Then End scenario

    Given I am on HomePage
    When I move to Login / Singin page
    Then I can registrate New user
    When I move to registation form
    Then I ifll registation form
     And Create new account













