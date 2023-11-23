package steps;

import org.example.managers.WebDriverSetup;
import org.example.pages.*;
import org.openqa.selenium.WebDriver;

public class BaseStep {

        private static final WebDriver driver = WebDriverSetup.initializeDriver();

//        HomePage homePage = new HomePage(driver);

        NavigationBar navigationBar = new NavigationBar(driver);
        LoginPage loginPage = new LoginPage(driver);
        SignupPage signupPage = new SignupPage(driver);
        CreateAccountMessage createAccountMessage = new CreateAccountMessage(driver);
        DeleteAccountMessage deleteAccountMessage = new DeleteAccountMessage(driver);



        private static final String BASE_URL = "https://automationexercise.com/";

        public String getBASE_URL(){
                return BASE_URL;
        }
        protected static WebDriver getDriver(){
                return driver;
        }

}
