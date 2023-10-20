package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;


public class StepsDefinitions extends BaseStep {

    HomePageSteps homePageSteps = new HomePageSteps();
    NavigationBarSteps navigationBarSteps = new NavigationBarSteps();
    LoginPageSteps loginPageSteps = new LoginPageSteps();
    SignupPageSteps signupPageSteps = new SignupPageSteps();
    CreateAccountMessageSteps createAccountMessageSteps = new CreateAccountMessageSteps();
    DeleteAccountMessageSteps deleteAccountMessageSteps = new DeleteAccountMessageSteps();


//    @AfterAll
//    public static void closeDriver(){
//        getDriver().quit();
//    }

    //START FEATURE

    // START REGISTRATION


    @Given("John on HomePage")
    public void johnOnHomePage() {
        homePageSteps.navigateToHomePage();

        Assertions.assertEquals(getBASE_URL(),getDriver().getCurrentUrl(),  "HomePage not upload");
        Assertions.assertEquals("color: orange;",navigationBarSteps.HomeLincColor(),
                "Home link not highlighted in color");
    }


    @Given("John not logged")
    public void johnNotLogged() {
        Assumptions.assumeTrue(navigationBarSteps.loginLinkIsDisplayed(),
                "Login/Signup link not displayed");
        Assumptions.assumeFalse(navigationBarSteps.loggedLinkIsDisplayed(), "Logged link is Displayed");

    }

    @When("John press Signup\\/Login")
    public void johnPressSignupLogin() {

        navigationBarSteps.signupLoginLinkClick();
//        Assertions.assertEquals(loginPage.getBASE_URL(), getDriver().getCurrentUrl(),
//               "Login page not upload" );
//        Assumptions.assumeTrue(createAccountSteps.signupFormIsDisplayed(),
//                "Signup form not displayed");
//        Assumptions.assumeTrue(createAccountSteps.nameFieldInSignupFormIsDisplayed(),
//                "Name field in Signup form not displayed");
//        Assumptions.assumeTrue(createAccountSteps.emailFieldInSignupFormIsDisplayed(),
//                "E-mail field in Signup form not displayed");
//        Assumptions.assumeTrue(createAccountSteps.signupButtonIsDisplayed(),
//                "Signup button is not displayed");
    }

    @When("John put NickName {string} and E-mail {string} in Signup form")
    public void johnPutNickNameAndEmailInSignupForm(String nickName,
                                                    String email) {
        loginPageSteps.inputNickName(nickName);
        loginPageSteps.inputSignupEmail(email);

//        Assertions.assertEquals(nickName,createAccountSteps.inputtedName(),
//                "Name not correct or field is empty");
//        Assertions.assertEquals(email,createAccountSteps.inputtedEmail(),
//                "Email not correct or field is empty");

        loginPageSteps.signupButtonClick();

//        Assertions.assertEquals(signupPage.getBaseUrl(), getDriver().getCurrentUrl());
    }


    @When("John put required data in ACCOUNT INFORMATION form: " +
            "Password {string} ," +
            "Date of Birth {string}.")
    public void johnPutRequiredDataInACCOUNTINFORMATIONForm(String password,
                                                            String dateOfBirth) {


        signupPageSteps.mrRadioButtonSelect();
        signupPageSteps.passwordInput(password);
        signupPageSteps.dayOfBirthSelect(dateOfBirth);
        signupPageSteps.monthOfBirthSelect(dateOfBirth);
        signupPageSteps.yearOfBirthSelect(dateOfBirth);
        signupPageSteps.checkBoxSignUpForOurNewsletterComfirm();
        signupPageSteps.checkBoxReceiveSpecialOffersFromOurPartnersConfirm();

    }


    @When("John put required data in ADDRESS INFORMATION form:" +
            " First Name {string}, " +
            "Last name {string}, " +
            "Address {string}," +
            " Country {string}," +
            " State {string}," +
            " City {string}, " +
            "Zipcode {int}," +
            " Phone {string}.")
    public void johnPutRequiredDataInADDRESSINFORMATIONForm(String firstName,
                                                            String lastName,
                                                            String address,
                                                            String country,
                                                            String state,
                                                            String city,
                                                            Integer zipcode,
                                                            String phone) {

        signupPageSteps.firstNameInput(firstName);
        signupPageSteps.lastNameInput(lastName);
        signupPageSteps.addressInput(address);
        signupPageSteps.countrySelect(country);
        signupPageSteps.stateInput(state);
        signupPageSteps.cityInput(city);
        signupPageSteps.zipcodeInput(zipcode);
        signupPageSteps.phoneInput(phone);
        signupPageSteps.createAccountButtonClick();

        Assertions.assertEquals("ACCOUNT CREATED!",createAccountMessageSteps.accountCreatedMessage(),
                "ACCOUNT CREATED! message not found");

        createAccountMessageSteps.accCreateConfirm();
    }


    @Then("John back to HomePage")
    public void johnBackToHomePage() {
        Assertions.assertEquals(getBASE_URL(),getDriver().getCurrentUrl(),  "HomePage not upload");
        Assertions.assertEquals("color: orange;",navigationBarSteps.HomeLincColor(),
                "Home link not highlighted in color");
    }


    @Then("John is logged")
    public void johnIsLogged() {
        Assumptions.assumeTrue(navigationBarSteps.loggedLinkIsDisplayed(),
                "'Logged in as' link not displayed ");
        Assertions.assertEquals("John",navigationBarSteps.loggedName(),
                "Name not correct or not displayed");
    }

    // END OF REGISTRATION

    //START LOGOUT


    @When("John press Logout")
    public void johnPressLogout() {
        navigationBarSteps.logoutLinkClick();
    }


    @When("John move to LoginPage")
    public void johnMoveToLoginPage() {
        Assertions.assertEquals(loginPage.getBASE_URL(),getDriver().getCurrentUrl(),
                "Signup / Login page not upload");
        Assertions.assertEquals( "color: orange;",navigationBarSteps.signupLoginLinkColor(),
                "'Signup / Login link not highlighted in color" );
    }
    //END LOGOUT

    //START LOGIN


    @When("John put {string} and {string} in Login form")
    public void johnPutAndInLoginForm(String email,
                                      String password) {
        loginPageSteps.inputLoginEmail(email);
        loginPageSteps.inputLoginPassword(password);
        loginPageSteps.loginButtonClick();
    }
    //END LOGIN

    //START DELETE


    @When("Press DeleteAccount")
    public void pressDeleteAccount() {
        navigationBarSteps.deleteAccountLinkClick();
    }


    @When("Confirm Account Deleted message")
    public void confirmAccountDeletedMessage() {
        Assertions.assertEquals("ACCOUNT DELETED!",deleteAccountMessageSteps.accountDeletedMessage(),
                "ACCOUNT DELETED! message not displayed");
        deleteAccountMessageSteps.deleteAccountConfirm();
    }

    //END DELETE

//    END OF FEATURE

}

