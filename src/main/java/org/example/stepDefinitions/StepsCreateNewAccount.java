package org.example.stepDefinitions;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.managers.PageObjectManager;
import org.example.managers.WebDriverSetup;
import org.example.pages.*;
import org.openqa.selenium.WebDriver;


public class StepsCreateNewAccount {

//    WebDriver driver = WebDriverSetup.initializeDriver();
//
//
//    PageObjectManager pageObjectManager = new PageObjectManager(driver);
//    HomePage homePage = pageObjectManager.getHomePage();
//    HeaderComponent headerComponent = pageObjectManager.getHeaderComponent();
//    LoginPage loginPage = pageObjectManager.getLoginPage();
//    SignupPage signupPage = pageObjectManager.getSignupPage();
//    AccountCreateMassage accountCreateMassage = pageObjectManager.getAccountCreatedPage();WebDriver driver = WebDriverSetup.initializeDriver();

    WebDriver driver;
    PageObjectManager pageObjectManager;
    HomePage homePage;
    HeaderComponent headerComponent;
    LoginPage loginPage;
    SignupPage signupPage;
   AccountCreateMassage accountCreateMassage;


    @Before
    public void setTestArea() {
        driver = WebDriverSetup.initializeDriver();
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        headerComponent = pageObjectManager.getHeaderComponent();
        loginPage = pageObjectManager.getLoginPage();
        signupPage = pageObjectManager.getSignupPage();
        accountCreateMassage = pageObjectManager.getAccountCreatedPage();
    }

    @Given("User on HomePage")
    public void userOnHomePage() {
        homePage.goToHomePage();
    }

    @Given("User not logged")
    public void userNotLogged() {
        headerComponent.loginButtonPresent();
    }

    @When("User move to login page")
    public void userMoveToLoginPage() {
        headerComponent.clickLogin();
    }

    @When("User correct fill form")
    public void userCorrectFillForm() {
        loginPage.nameInput();
        loginPage.emailInput();
    }

    @When("User press Signup")
    public void userPressSignup() {
        loginPage.signupButtonClick();
    }

    @When("User move to Signup page")
    public void userMoveToSignupPage() {

    }

    @When("User correct fill to registration form")
    public void userCorrectFillToRegistrationForm() {
        signupPage.titleSelect();
        signupPage.passwdInput();
        signupPage.daySelect();
        signupPage.monthSelect();
        signupPage.yearSelect();
        signupPage.newsletterClick();
        signupPage.offerClick();
        signupPage.first_nameInput();
        signupPage.last_nameInput();
        signupPage.addressInput();
        signupPage.countrySelect();
        signupPage.stateInput();
        signupPage.cityInput();
        signupPage.zipcodeInput();
        signupPage.phoneInput();
    }

    @When("User press Create Account")
    public void userPressCreateAccount() {
        signupPage.createAccButtonClick();
    }

    @Then("New User Account was created")
    public void newUserAccountWasCreated() {

    }

    @When("User press Continue")
    public void userPressContinue() {
        accountCreateMassage.accCreateConfirm();

    }

    @Then("User back to Home Page")
    public void userBackToHomePage() {

    }

    @Then("User is logged")
    public void userIsLogged() {

    }

//    @After
//    public void removeDriver() {
//        driver.close();
//        driver.quit();
//    }


}