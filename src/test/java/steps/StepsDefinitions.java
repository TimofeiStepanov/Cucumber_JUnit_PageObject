package steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;


public class StepsDefinitions extends BaseStep {

    CreateAccountSteps createAccountSteps = new CreateAccountSteps();
    DeleteAccountSteps deleteAccountSteps = new DeleteAccountSteps();
    LogoutSteps logoutSteps = new LogoutSteps();
    LoginSteps loginSteps = new LoginSteps();


    //New Steps init

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

        navigationBarSteps.SignupLoginLinkClick();
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
    public void johnPutNickNameAndEmailInSignupForm(String nickName, String email) {
        loginPageSteps.inputNickName(nickName);
        loginPageSteps.inputEmail(email);

//        Assertions.assertEquals(nickName,createAccountSteps.inputtedName(),
//                "Name not correct or field is empty");
//        Assertions.assertEquals(email,createAccountSteps.inputtedEmail(),
//                "Email not correct or field is empty");

        loginPageSteps.signupButtonClick();

//        Assertions.assertEquals(signupPage.getBaseUrl(), getDriver().getCurrentUrl());
    }


    @When("John put required data in ACCOUNT INFORMATION form: Password {string} ,Date of Birth {string}.")
    public void johnPutRequiredDataInACCOUNTINFORMATIONForm(String password, String dateOfBirth) {


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
//        signupPage.getCreateAccountButton().click();
//        createAccountSteps.createAccountMessageTest();
//        createAccountSteps.confirmButtonAccountCreatedMessageTest();
    }


    @Then("John back to HomePage")
    public void johnBackToHomePage() {
        createAccountSteps.returnToHomePageTest();
    }


    @Then("John is logged")
    public void johnIsLogged() {
        createAccountSteps.loggedNameInNavBarTest();
    }

    // END OF REGISTRATION

    //START LOGOUT


    @When("John press Logout")
    public void johnPressLogout() {
        logoutSteps.logoutLinkInNavBarTest();
    }


    @When("John move to LoginPage")
    public void johnMoveToLoginPage() {
//        createAccountSteps.loginPageUploadTest();
    }
    //END LOGOUT

    //START LOGIN


    @When("John put {string} and {string} in Login form")
    public void johnPutAndInLoginForm(String email, String password) {
        loginSteps.emailInputLoginFormTest(email);
        loginSteps.passwdInputLoginFormTest(password);
//        loginSteps.loginButtonTest();
    }
    //END LOGIN

    //START DELETE


    @When("Press DeleteAccount")
    public void pressDeleteAccount() {
        deleteAccountSteps.deleteAccountNavBarLinkTest();
    }


    @When("Confirm Account Deleted message")
    public void confirmAccountDeletedMessage() {
        deleteAccountSteps.deleteAccountMessageTest();
    }
    //END DELETE

//    END OF FEATURE

}

