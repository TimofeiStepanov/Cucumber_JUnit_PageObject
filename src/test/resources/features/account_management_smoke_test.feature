Feature: Account management functionality
  scenarios on 'http://automationexercise.com'
  As a user John
  I want to be able create an account on site
  I want to be able login to my account
  I want to be able logout from my account
  I want to be able delete my account

  Rule: John REGISTERING in shop like new user.

	@Smoke
	@Quick
	@Functional
	@E2E
	@Negative
	@Positive
	Scenario : John move to Signup / Login page.
	  Given John on HomePage
	  And   John not logged
	  When John press Signup/Login
	  Then John move to LoginPage

	@E2E
	Scenario Outline: John can see correct Signup form.
	  Given Signup form is displayed
	  When John see message <Message>
	  And See Name input field in Signup form
	  And See Email Address input field in Signup form
	  And See Signup Button
	  Then John can fill out the signup form.

	  Examples:
		| Message          |
		| New User Signup! |

	@Smoke
	  @Quick
	Scenario Outline: John filling the signup form.
	  Then John put NickName <Nick Name> and E-mail <E-mail> in Signup form
	  Examples:
		| Nick Name | E-mail          |
		| "John"    | "Wick@mail.com" |
	  @Functional
	  @E2E
	  @Positive
	Scenario Outline: John filling the signup form.
	  When John put NickName <Nick Name>
	  And E-mail <E-mail> in Signup form
	  And press Signup button
	  Then John move to Signup page

	  Examples:
		| Nick Name | E-mail          |
		| "John"    | "Wick@mail.com" |


	@Functional
	  @E2E
	  @Negative
	Scenario Outline: John filling the signup form not correct.
	  When John put NickName <NickName>
	  And E-mail <E-mail> in Signup form
	  And press Signup button
	  Then John see Massage <Message>

	  Examples:
		| NickName | E-mail          | Message |
		| "John"   | "Wickmail.com"  | ""      |
		| ""       | "Wick@mail.com" | ""      |
		| "John"   | ""              | ""      |
		| ""       | ""              | ""      |

	@Smoke
	Scenario: John can see Information Form
	  Given Informaton Form is Displayed.
	  Then Field for required data is displayed

	@E2E
	Scenario: John can see correct Information data form

	  When John See ENTER ACCOUNT INFORMATION title
	  When John can See ADDRESS INFORMATION titile
	  When Mr. and Mrs radio button is displayed
	  When Field for required data is displayed
	  And Check Box  Sign up for our newsletter! is displayed
	  And Check Box Receive special offers from our partners!
	  And Company field is displayed
	  And Button Create Account is displayed
	  Then John can fill Account Information Form

	@Smoke
	  @Quick
	Scenario Outline: John filling required data in Information Form

	  And John put required data in ACCOUNT INFORMATION form: Password <Password> ,Date of Birth <DateOfBirth>.
	  And John put required data in ADDRESS INFORMATION form: First Name <FirstName>, Last name <LastName>, Address <Address>, Country <Country>, State <State>, City <City>, Zipcode <Zipcode>, Phone <Phone>.
	  Then John back to HomePage
	  And John is logged
	  Examples:
		| FirstName | LastName | Password    | DateOfBirth        | Address          | Country         | State   | City     | Zipcode | Phone         |
		| "John"    | "Wick"   | "qasxdsewr" | "13.November.1977" | "Any street 5-6" | "United States" | "Texas" | "Dallas" | 13245   | "+1324542542" |

	@E2E
	Scenario: John select gender prefix
	  When John select Mr. radio button
	@E2E
	Scenario Outline: John see that Name and Email is filled
	  And Name field is filled automatikal Name <Nick Name>
	  And Email field is filled automatikal E-mail <E-mail>
	  Examples:
		| Nick Name | E-mail          |
		| "John"    | "Wick@mail.com" |
	@E2E
	@Functional
	Scenario: John input Password
	  When John input Password <Password>
	  Then Password hidden under asterisks < Passwd displayed >
		| Password    | Passwd displayed |
		| "qasxdsewr" | "********"       |
	@E2E
	  @Functional
	  @Positive
	Scenario Outline: John input Day Of Birth with Keyboard
	  Given Day field active
	  When John enter Number1 <Num1> and Number2 <Num2>
	  Then Day of Birth equal test Number<Test Num>
	  Examples:
		| Num1 | Num2 | Test Num |
		| "1"  | "3"  | "13"     |
	  |"1"   |"1"   |"11"      |
	  |"2"   |"2"   |"22"      |
	  |"3"   |"1"   |"31"      |




	@E2E
	@Functional
	@Negative
	Scenario Outline: John input Day Of Birth with Keyboard
	  Given Day field active13
	  When John enter Number1 <Num1>, Number2 <Num2> and Number3<Num3>
	  Then Day of Birth equal <Test Number>
	  Examples:
		| Num1 | Num2 | Num3| Test Number |
		| "1"     | "3"  |"5"   |"13"        |



	@E2E
	@Functional
	@Positive
	Scenario: John input Day Of Birth with mouth
	  When John click on Day
	  Then John select Day in Drop Down list


	@Functional
	Scenario:John LOGOUT from shop
	  When John is logged
	  And John press Logout
	  Then John move to LoginPage
	  And John not logged


	@Quick
	Scenario:John LOGOUT from shop
	  When John press Logout
	  Then John not logged


	@Smoke
	Scenario:John LOGOUT from shop
	  Given John is logged
	  And John press Logout
	  And John not logged

	@Quick
	Scenario Outline: John LOGIN to shop
	  Given John not logged
	  And John put <E-mail> and <Password> in Login form
	  And John is logged
	  Examples:
		| E-mail          | Password    |
		| "Wick@mail.com" | "qasxdsewr" |

	@Smoke
	Scenario Outline: John LOGIN to shop
	  Given John on HomePage
	  And John not logged
	  When John press Signup/Login
	  And John put <E-mail> and <Password> in Login form
	  Then John back to HomePage
	  And John is logged
	  Examples:
		| E-mail          | Password    |
		| "Wick@mail.com" | "qasxdsewr" |

	@Quick
	Scenario: John DELETE Account
	  Given John is logged
	  And Press DeleteAccount
	  And Confirm Account Deleted message
	  Then John not logged
	@Smoke
	Scenario: John DELETE Account
	  When John is logged
	  And Press DeleteAccount
	  And Confirm Account Deleted message
	  Then John back to HomePage
	  And John not logged