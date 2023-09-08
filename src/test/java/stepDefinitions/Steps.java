package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.managers.PageObjectManager;
import org.example.pages.HeaderComponent;
import org.example.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;


public class Steps {

    WebDriver driver =null;

    HomePage homePage;
    PageObjectManager pageObjectManager;
    HeaderComponent headerComponent;


    @Given("User on HomePage")
    public void userOnHomePage() {
        driver = TestBase.initializeDriver();
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        homePage.goToHomePage();
    }

    @Given("User not logged")
    public void userNotLogged() {
        headerComponent= pageObjectManager.getHeaderComponent();
        headerComponent.loginButtonPresent();
    }

    @When("User move to login page")
    public void userMoveToLoginPage() {
        headerComponent.clickLogin();
    }

    @When("User correct fill form")
    public void userCorrectFillForm() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("press Singup")
    public void pressSingup() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("move to Singup page")
    public void moveToSingupPage() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User correct fill to registration form")
    public void userCorrectFillToRegistrationForm() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("press Create Account")
    public void pressCreateAccount() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("New User Account was created")
    public void newUserAccountWasCreated() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User press Continue")
    public void userPressContinue() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User on Home Page")
    public void userBAckToHomePage() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("logged")
    public void logged() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}