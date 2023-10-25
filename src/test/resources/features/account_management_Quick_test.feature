Feature: Account management Quick tests
  for 'http://automationexercise.com'

  As a user John
  I want to be able create an account on site
  I want to be able login to my account
  I want to be able logout from my account
  I want to be able delete my account

  @Quick
  Scenario: John move to Signup / Login page.
	Given John on HomePage
	When John press Signup/Login
	Then John move to LoginPage

@Quick
Scenario Outline: John filling the signup form.
  Then John put NickName <Nick Name> and E-mail <E-mail> in Signup form
  Examples:
	| Nick Name | E-mail          |
	| "John"    | "Wick@mail.com" |

  @Quick
  Scenario Outline: John filling required data in Information Form
	And John put required data in ACCOUNT INFORMATION form: Password <Password> ,Date of Birth <DateOfBirth>.
	And John put required data in ADDRESS INFORMATION form: First Name <FirstName>, Last name <LastName>, Address <Address>, Country <Country>, State <State>, City <City>, Zipcode <Zipcode>, Phone <Phone>.
	And John is logged
	Examples:
	  | FirstName | LastName | Password    | DateOfBirth        | Address          | Country         | State   | City     | Zipcode | Phone         |
	  | "John"    | "Wick"   | "qasxdsewr" | "13.November.1977" | "Any street 5-6" | "United States" | "Texas" | "Dallas" | 13245   | "+1324542542" |
  @Quick
  Scenario:John LOGOUT from shop
	When John press Logout
	Then John not logged

  @Quick
  Scenario Outline: John LOGIN to shop
	And John put <E-mail> and <Password> in Login form
	And John is logged
	Examples:
	  | E-mail          | Password    |
	  | "Wick@mail.com" | "qasxdsewr" |
  @Quick
  Scenario: John DELETE Account
	And Press DeleteAccount
	And Confirm Account Deleted message
	Then John not logged