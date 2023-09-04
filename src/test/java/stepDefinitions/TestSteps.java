package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.example.managers.PageObjectManager;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;

import static stepDefinitions.TestBase.initializeDriver;


public class TestSteps {
    public WebDriver driver;
    HomePage homePage;
    PageObjectManager pageObjectManager;

    TestBase testBase = new TestBase();



    @Given("I am on HomePage")
    public void iAmOnHomePage() throws InterruptedException {

        WebDriver driver = initializeDriver();
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        homePage.goToHomePage();
    }

    @When("I move to Login \\/ Singin page")
    public void iMoveToLoginSinginPage() {

        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("I move to registration form")
    public void iMoveToRegistrationForm() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("I fill registration form")
    public void iFillRegistrationForm() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("Create new account")
    public void createNewAccount() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}