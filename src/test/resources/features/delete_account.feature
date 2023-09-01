Feature: Automation end2end tests   to verify users
  scenarios on 'http://automationexercise.com'
  As user
  I want login to my account
  I want delete my account

Scenario: Delete account
  Then Click 'Delete Account' button
  When Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
  Then End scenario