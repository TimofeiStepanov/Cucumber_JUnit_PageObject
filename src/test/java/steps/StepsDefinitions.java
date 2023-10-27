package steps;


import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;


public class StepsDefinitions extends BaseStep {


    StepsOnHomePage stepsOnHomePage = new StepsOnHomePage();
    StepsOnNavigationBar stepsOnNavigationBar = new StepsOnNavigationBar();
    StepsOnLoginPage stepsOnLoginPage = new StepsOnLoginPage();
    StepsOnSignupPage stepsOnSignupPage = new StepsOnSignupPage();
    StepsOnCreateAccountMessagePage stepsOnCreateAccountMessagePage = new StepsOnCreateAccountMessagePage();
    StepsOnDeleteAccountMessagePage stepsOnDeleteAccountMessagePage = new StepsOnDeleteAccountMessagePage();

    @BeforeAll
    public static void openDriver() {
        getDriver();
    }

    @AfterAll
    public static void closeDriver(){
        getDriver().quit();
    }

    //START FEATURE

    // START REGISTRATION


    @Given("John on HomePage")
    public void johnOnHomePage() {
        stepsOnHomePage.navigateToHomePage();

        Assertions.assertEquals(getBASE_URL(),getDriver().getCurrentUrl(),  "HomePage not upload");
        Assertions.assertEquals("color: orange;", stepsOnNavigationBar.HomeLincColor(),
                "Home link not highlighted in color");
    }


    @Given("John not logged")
    public void johnNotLogged() {
        Assumptions.assumeTrue(stepsOnNavigationBar.loginLinkIsDisplayed(),
                "Login/Signup link not displayed");
        Assumptions.assumeFalse(stepsOnNavigationBar.loggedLinkIsDisplayed(), "Logged link is Displayed");

    }

    @When("John press Signup\\/Login")
    public void johnPressSignupLogin() {

        stepsOnNavigationBar.signupLoginLinkClick();
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
        stepsOnLoginPage.inputNickName(nickName);
        stepsOnLoginPage.inputSignupEmail(email);

//        Assertions.assertEquals(nickName,createAccountSteps.inputtedName(),
//                "Name not correct or field is empty");
//        Assertions.assertEquals(email,createAccountSteps.inputtedEmail(),
//                "Email not correct or field is empty");

        stepsOnLoginPage.signupButtonClick();

//        Assertions.assertEquals(signupPage.getBaseUrl(), getDriver().getCurrentUrl());
    }


    @When("John put required data in ACCOUNT INFORMATION form: " +
            "Password {string} ," +
            "Date of Birth {string}.")
    public void johnPutRequiredDataInACCOUNTINFORMATIONForm(String password,
                                                            String dateOfBirth) {


        stepsOnSignupPage.mrRadioButtonSelect();
        stepsOnSignupPage.passwordInput(password);
        stepsOnSignupPage.dayOfBirthSelect(dateOfBirth);
        stepsOnSignupPage.monthOfBirthSelect(dateOfBirth);
        stepsOnSignupPage.yearOfBirthSelect(dateOfBirth);
        stepsOnSignupPage.checkBoxSignUpForOurNewsletterComfirm();
        stepsOnSignupPage.checkBoxReceiveSpecialOffersFromOurPartnersConfirm();

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

        stepsOnSignupPage.firstNameInput(firstName);
        stepsOnSignupPage.lastNameInput(lastName);
        stepsOnSignupPage.addressInput(address);
        stepsOnSignupPage.countrySelect(country);
        stepsOnSignupPage.stateInput(state);
        stepsOnSignupPage.cityInput(city);
        stepsOnSignupPage.zipcodeInput(zipcode);
        stepsOnSignupPage.phoneInput(phone);
        stepsOnSignupPage.createAccountButtonClick();

        Assertions.assertEquals("ACCOUNT CREATED!", stepsOnCreateAccountMessagePage.accountCreatedMessage(),
                "ACCOUNT CREATED! message not found");

        stepsOnCreateAccountMessagePage.accCreateConfirm();
    }


    @Then("John back to HomePage")
    public void johnBackToHomePage() {
        Assertions.assertEquals(getBASE_URL(),getDriver().getCurrentUrl(),  "HomePage not upload");
        Assertions.assertEquals("color: orange;", stepsOnNavigationBar.HomeLincColor(),
                "Home link not highlighted in color");
    }


    @Then("John is logged")
    public void johnIsLogged() {
        Assumptions.assumeTrue(stepsOnNavigationBar.loggedLinkIsDisplayed(),
                "'Logged in as' link not displayed ");
        Assertions.assertEquals("John", stepsOnNavigationBar.loggedName(),
                "Name not correct or not displayed");
    }

    // END OF REGISTRATION

    //START LOGOUT


    @When("John press Logout")
    public void johnPressLogout() {
        stepsOnNavigationBar.logoutLinkClick();
    }


    @When("John move to LoginPage")
    public void johnMoveToLoginPage() {
        Assertions.assertEquals(loginPage.getBASE_URL(),getDriver().getCurrentUrl(),
                "Signup / Login page not upload");
        Assertions.assertEquals( "color: orange;", stepsOnNavigationBar.signupLoginLinkColor(),
                "'Signup / Login link not highlighted in color" );
    }
    //END LOGOUT

    //START LOGIN


    @When("John put {string} and {string} in Login form")
    public void johnPutAndInLoginForm(String email,
                                      String password) {
        stepsOnLoginPage.inputLoginEmail(email);
        stepsOnLoginPage.inputLoginPassword(password);
        stepsOnLoginPage.loginButtonClick();
    }
    //END LOGIN

    //START DELETE


    @When("Press DeleteAccount")
    public void pressDeleteAccount() {
        stepsOnNavigationBar.deleteAccountLinkClick();
    }


    @When("Confirm Account Deleted message")
    public void confirmAccountDeletedMessage() {
        Assertions.assertEquals("ACCOUNT DELETED!", stepsOnDeleteAccountMessagePage.accountDeletedMessage(),
                "ACCOUNT DELETED! message not displayed");
        stepsOnDeleteAccountMessagePage.deleteAccountConfirm();
    }


    @Given("Signup form is displayed")
    public void signupFormIsDisplayed() {
    }

    @When("John see message <Message>")
    public void johnSeeMessageMessage() {
    }

    @And("See Name input field in Signup form")
    public void seeNameInputFieldInSignupForm() {
    }

    @And("See Email Address input field in Signup form")
    public void seeEmailAddressInputFieldInSignupForm() {
    }

    @And("See Signup Button")
    public void seeSignupButton() {
    }

    @Then("John can fill out the signup form.")
    public void johnCanFillOutTheSignupForm() {
    }

    @When("John put NickName <Nick Name>")
    public void johnPutNickNameNickName() {
    }

    @And("E-mail <E-mail> in Signup form")
    public void eMailEMailInSignupForm() {
    }

    @And("press Signup button")
    public void pressSignupButton() {
    }

    @Then("John move to Signup page")
    public void johnMoveToSignupPage() {
    }

    @Then("John see Massage <Message>")
    public void johnSeeMassageMessage() {
    }

    @Given("Information Form is Displayed.")
    public void informatonFormIsDisplayed() {
    }

    @Then("Field for required data is displayed")
    public void fieldForRequiredDataIsDisplayed() {
    }

    @When("John See ENTER ACCOUNT INFORMATION title")
    public void johnSeeENTERACCOUNTINFORMATIONTitle() {
    }

    @When("John can See ADDRESS INFORMATION title")
    public void johnCanSeeADDRESSINFORMATIONTitle() {
    }

    @When("Mr. and Mrs radio button is displayed")
    public void mrAndMrsRadioButtonIsDisplayed() {
    }

    @And("Check Box  Sign up for our newsletter! is displayed")
    public void checkBoxSignUpForOurNewsletterIsDisplayed() {
    }

    @And("Check Box Receive special offers from our partners!")
    public void checkBoxReceiveSpecialOffersFromOurPartners() {
    }

    @And("Company field is displayed")
    public void companyFieldIsDisplayed() {
    }

    @And("Button Create Account is displayed")
    public void buttonCreateAccountIsDisplayed() {
    }

    @Then("John can fill Account Information Form")
    public void johnCanFillAccountInformationForm() {
    }

    @When("John select Mr. radio button")
    public void johnSelectMrRadioButton() {
    }

    @And("Name field is filled automatikal Name <Nick Name>")
    public void nameFieldIsFilledAutomatikalNameNickName() {
    }

    @And("Email field is filled automatikal E-mail <E-mail>")
    public void emailFieldIsFilledAutomatikalEMailEMail() {
    }

    @When("John input Password <Password>")
    public void johnInputPasswordPassword() {
    }

    @Then("Password hidden under asterisks < Passwd displayed >")
    public void passwordHiddenUnderAsterisksPasswdDisplayed() {
    }

    @Given("Day field active")
    public void dayFieldActive() {
    }

    @Then("Day of Birth equal test Number<Test Num>")
    public void dayOfBirthEqualTestNumberTestNum() {
    }

    @Given("Day field active{int}")
    public void dayFieldActive(int arg0) {
    }

    @When("John enter Number{int} <Num{int}>, Number{int} <Num{int}> and Number{int}<Num{int}>")
    public void johnEnterNumberNumNumberNumAndNumberNum(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5) {
    }

    @Then("Day of Birth equal <Test Number>")
    public void dayOfBirthEqualTestNumber() {
    }

    @When("John click on Day")
    public void johnClickOnDay() {
    }

    @Then("John select Day in Drop Down list")
    public void johnSelectDayInDropDownList() {
    }



    //END DELETE

//    END OF FEATURE

}

