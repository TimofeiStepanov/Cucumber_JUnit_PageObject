Feature: Account management tests
  scenarios on 'http://automationexercise.com'

  As a user John
  I want to be able create an account on site
  I want to be able login to my account
  I want to be able logout from my account
  I want to be able delete my account

#  Rule: John REGISTERING in shop like new user.

  @Functional @E2E @Negative @Positive
  Scenario: John move to Signup / Login page.
	Given John on HomePage
	And   John not logged
	When John press Signup/Login
	Then John move to LoginPage

  @E2E
  Scenario Outline: John can see correct Signup form
	Given Signup form is displayed
	When John see message <Message>
	And See Name input field in Signup form
	And See Email Address input field in Signup form
	And See Signup Button
	Then John can fill out the signup form.

	Examples:
	  | Message          |
	  | New User Signup! |


  @Functional @E2E @Positive
  Scenario Outline: John filling the signup form.
	When John put NickName <Nick Name>
	And E-mail <E-mail> in Signup form
	And press Signup button
	Then John move to Signup page

	Examples:
	  | Nick Name | E-mail          |
	  | "John"    | "Wick@mail.com" |


  @Functional @E2E @Negative
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


  @E2E
  Scenario: John can see correct Information data form
	Given Information Form is Displayed.
	When John See ENTER ACCOUNT INFORMATION title
	When John can See ADDRESS INFORMATION title
	When Mr. and Mrs radio button is displayed
	When Field for required data is displayed
	And Check Box  Sign up for our newsletter! is displayed
	And Check Box Receive special offers from our partners!
	And Company field is displayed
	And Button Create Account is displayed
	Then John can fill Account Information Form

  @E2E @Functional
  Scenario: John select gender prefix
	When John select Mr. radio button

  @E2E @Functional
  Scenario Outline: John see that Name and Email is filled
	And Name field is filled automatikal Name <Nick Name>
	And Email field is filled automatikal E-mail <E-mail>
	Examples:
	  | Nick Name | E-mail          |
	  | "John"    | "Wick@mail.com" |

  @E2E @Functional
  Scenario: John input Password
	When John input Password <Password>
	Then Password hidden under asterisks < Passwd displayed >
	  | Password    | Passwd displayed |
	  | "qasxdsewr" | "********"       |

  @E2E @Functional @Positive
  Scenario Outline: John input Day Of Birth with Keyboard
	Given Day field active
	When John enter Number1 <Num1> and Number2 <Num2>
	Then Day of Birth equal test Number<Test Num>
	Examples:
	  | Num1 | Num2 | Test Num |
	  | "1"  | "3"  | "13"     |
	  | "1"  | "1"  | "11"     |
	  | "2"  | "2"  | "22"     |
	  | "3"  | "1"  | "31"     |


  @E2E @Functional @Negative
  Scenario Outline: John input Day Of Birth with Keyboard
	Given Day field active13
	When John enter Number1 <Num1>, Number2 <Num2> and Number3<Num3>
	Then Day of Birth equal <Test Number>
	Examples:
	  | Num1 | Num2 | Num3 | Test Number |
	  | "1"  | "3"  | "5"  | "13"        |


  @E2E @Functional @Positive
  Scenario: John input Day Of Birth with mouth
	When John click on Day
	Then John select Day in Drop Down list

  @E2E @Functional
  Scenario Outline: John input Month of Birth with keyboard
	When Month fild is active
	Then John input Month value <Month>
	And Mounth displayed like <Test Month>
	Examples:
	  | Month      | Test Month |
	  | "N"        | "November" |
	  | "No"       | "November" |
	  | "Nov"      | "November" |
	  | "Nove"     | "November" |
	  | "Novem"    | "November" |
	  | "Novemb"   | "November" |
	  | "Novembe"  | "November" |
	  | "November" | "November" |


  @E2E @Functional
  Scenario: John input Month Of Birth with mouth
	When John click on Month
	Then John select Month in Drop Down list

  @E2E @Functional
  Scenario Outline: Scenario Outline: John input Year of Birth with keyboard
	When Year fild is active
	Then John input Year <Thousands> <Hundreds> <Dozens> <Units>
	And Year displayed like <Test Year>
	Examples:
	  | Thousands | Hundreds | Dozens | Units | Test Year |
	  | "1"       | "9"      | "7"    | "7"   | "1977"    |

  @E2E @Functional
  Scenario: John input Year Of Birth with mouth
	When John click on Year
	Then John select Year in Drop Down list

  @E2E @Functional
  Scenario: John select check boxes
	Then Check Box Receive special offers from our partners! is enable
	Then Check Box  Sign up for our newsletter! is enable

  @E2E @Functional @Negative
  Scenario Outline: John filling required data in Address Information Form
	When John put required data in ADDRESS INFORMATION form: First Name <FirstName>
	And John put required data in ADDRESS INFORMATION form: Last name <LastName>
	And John put required data in ADDRESS INFORMATION form: Address <Address>
	And John put required data in ADDRESS INFORMATION form: Country <Country>
	And John put required data in ADDRESS INFORMATION form: State <State>
	And John put required data in ADDRESS INFORMATION form: City <City>
	And John put required data in ADDRESS INFORMATION form: Zipcode <Zipcode>
	And John put required data in ADDRESS INFORMATION form: Phone <Phone>
	Then John see message <Message> Some required field is empty
	Examples:
	  | FirstName | LastName | Address          | Country         | State   | City     | Zipcode | Phone         | Message |
	  | ""        | "Wick"   | "Any street 5-6" | "United States" | "Texas" | "Dallas" | 13245   | "+1324542542" | ""      |
	  | "John"    | ""       | "Any street 5-6" | "United States" | "Texas" | "Dallas" | 13245   | "+1324542542" | ""      |
	  | "John"    | "Wick"   | ""               | "United States" | "Texas" | "Dallas" | 13245   | "+1324542542" | ""      |
	  | "John"    | "Wick"   | "Any street 5-6" | ""              | "Texas" | "Dallas" | 13245   | "+1324542542" | ""      |
	  | "John"    | "Wick"   | "Any street 5-6" | "United States" | ""      | "Dallas" | 13245   | "+1324542542" | ""      |
	  | "John"    | "Wick"   | "Any street 5-6" | "United States" | "Texas" | ""       | 13245   | "+1324542542" | ""      |
	  | "John"    | "Wick"   | "Any street 5-6" | "United States" | "Texas" | "Dallas" |         | "+1324542542" | ""      |
	  | "John"    | "Wick"   | "Any street 5-6" | "United States" | "Texas" | "Dallas" | 13245   | ""            | ""      |

  @E2E @Functional @Positive
  Scenario Outline: John filling required data in Address Information Form
	When John put required data in ADDRESS INFORMATION form: First Name <FirstName>
	And John put required data in ADDRESS INFORMATION form: Last name <LastName>
	And John put required data in ADDRESS INFORMATION form: Address <Address>
	And John put required data in ADDRESS INFORMATION form: Country <Country>
	And John put required data in ADDRESS INFORMATION form: State <State>
	And John put required data in ADDRESS INFORMATION form: City <City>
	And John put required data in ADDRESS INFORMATION form: Zipcode <Zipcode>
	And John put required data in ADDRESS INFORMATION form: Phone <Phone>
	Then John can finish Create Account
	Examples:
	  | FirstName | LastName | Address          | Country         | State   | City     | Zipcode | Phone         |
	  | "John"    | "Wick"   | "Any street 5-6" | "United States" | "Texas" | "Dallas" | 13245   | "+1324542542" |

  @E2E @Positive
  Scenario Outline: John see his info filed correct
	When Check required data in ADDRESS INFORMATION form: First Name <FirstName>
	And Check required data in ADDRESS INFORMATION form: Last name <LastName>
	And Check required data in ADDRESS INFORMATION form: Address <Address>
	And Check required data in ADDRESS INFORMATION form: Country <Country>
	And Check required data in ADDRESS INFORMATION form: State <State>
	And Check required data in ADDRESS INFORMATION form: City <City>
	And Check required data in ADDRESS INFORMATION form: Zipcode <Zipcode>
	And Check required data in ADDRESS INFORMATION form: Phone <Phone>
	Then John can finish Create Account

	Examples:
	  | FirstName | LastName | Address          | Country         | State   | City     | Zipcode | Phone         |
	  | "John"    | "Wick"   | "Any street 5-6" | "United States" | "Texas" | "Dallas" | 13245   | "+1324542542" |



  @Functional
  Scenario:John LOGOUT from shop
	When John is logged
	And John press Logout
	Then John move to LoginPage
	And John not logged

  @E2E @Functional
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


  Scenario: John DELETE Account
	And Press DeleteAccount
	And Confirm Account Deleted message
	Then John not logged


  Scenario: John DELETE Account
	When John is logged
	And Press DeleteAccount
	And Confirm Account Deleted message
	Then John back to HomePage
	And John not logged