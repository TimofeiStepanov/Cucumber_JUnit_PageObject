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

    @When("John enter Number{int} <Num{int}> and Number{int} <Num{int}>")
    public void johnEnterNumberNumAndNumberNum(int arg0, int arg1, int arg2, int arg3) {
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

