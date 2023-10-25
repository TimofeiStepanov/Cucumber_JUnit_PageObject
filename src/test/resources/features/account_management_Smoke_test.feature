Feature: Account management Smoke tests
  for 'http://automationexercise.com'

  As a user John
  I want to be able create an account on site
  I want to be able login to my account
  I want to be able logout from my account
  I want to be able delete my account

@Smoke
  Scenario: John move to Signup / Login page.
	Given John on HomePage
	And   John not logged
	When John press Signup/Login
	Then John move to LoginPage

  @Smoke
  Scenario Outline: John filling the signup form.
	When Signup form is displayed
	Then John put NickName <Nick Name> and E-mail <E-mail> in Signup form
	Examples:
	  | Nick Name | E-mail          |
	  | "John"    | "Wick@mail.com" |

  @Smoke
  Scenario Outline: John can see Information Form
	When Information Form is Displayed.
	And Field for required data is displayed
	And John put required data in ACCOUNT INFORMATION form: Password <Password> ,Date of Birth <DateOfBirth>.
	And John put required data in ADDRESS INFORMATION form: First Name <FirstName>, Last name <LastName>, Address <Address>, Country <Country>, State <State>, City <City>, Zipcode <Zipcode>, Phone <Phone>.
	And John is logged
	Examples:
	  | FirstName | LastName | Password    | DateOfBirth        | Address          | Country         | State   | City     | Zipcode | Phone         |
	  | "John"    | "Wick"   | "qasxdsewr" | "13.November.1977" | "Any street 5-6" | "United States" | "Texas" | "Dallas" | 13245   | "+1324542542" |

  @Smoke
  Scenario:John LOGOUT from shop
	Given John is logged
	And John press Logout
	And John not logged

	@Smoke
	Scenario Outline: John LOGIN to shop
	When John not logged
	  When John press Signup/Login
	  And John put <E-mail> and <Password> in Login form
	  Then John back to HomePage
	  And John is logged
	  Examples:
		| E-mail          | Password    |
		| "Wick@mail.com" | "qasxdsewr" |

  @Smoke
  Scenario: John DELETE Account
	When John is logged
	And Press DeleteAccount
	And Confirm Account Deleted message
	Then John back to HomePage
	And John not logged