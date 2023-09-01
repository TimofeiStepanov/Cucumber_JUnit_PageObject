Feature: Automation end2end tests   to verify users
  scenarios on 'http://automationexercise.com'
  As a user
  I want login to my account
  So that I can access the website's features

Scenario:  Login with valid credentials
  Given I am on HomePage
  When  Verify that home page is visible successfully
  Then  Click on 'Signup / Login' button
  When Verify 'New User Signup!' is visible
  And  Enter e-mail address
  And  Enter Password
