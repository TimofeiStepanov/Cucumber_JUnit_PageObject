package runners;


import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.example.managers.PageObjectManager;
import org.example.managers.WebDriverSetup;
import org.example.pages.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/new_account_create.feature",
        glue = {"org/example/stepDefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class TestRunner {

//    WebDriver driver;
//    PageObjectManager pageObjectManager;
//    HomePage homePage;
//    HeaderComponent headerComponent;
//    LoginPage loginPage;
//    SignupPage signupPage;
//    AccountCreateMassage accountCreatedPage;
//    @BeforeAll
//    public void setDriver() {
//        driver = WebDriverSetup.initializeDriver();
//        pageObjectManager = new PageObjectManager(driver);
//        homePage = pageObjectManager.getHomePage();
//        headerComponent = pageObjectManager.getHeaderComponent();
//        loginPage = pageObjectManager.getLoginPage();
//        signupPage = pageObjectManager.getSignupPage();
//        accountCreatedPage = pageObjectManager.getAccountCreatedPage();
//    }

}
