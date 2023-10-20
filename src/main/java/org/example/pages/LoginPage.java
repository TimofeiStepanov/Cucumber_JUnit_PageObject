package org.example.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    final WebDriver driver;
    private static final String BASE_URL = "https://automationexercise.com/login";


    @FindBy(className = "signup-form")
    private static WebElement signupForm;
    @FindBy(xpath = "//*[@data-qa='signup-name']")
    private static WebElement nameInputSignupField;

    @FindBy(xpath = "//*[@data-qa='signup-email']")
    private static WebElement emailSignupInputField;

    @FindBy(xpath = "//*[@data-qa='signup-button']")
    private static WebElement signupButton;
    @FindBy(xpath = "//*[@data-qa='login-email']")
    private static WebElement emailLoginInputField;
    @FindBy(xpath = "//*[@data-qa='login-password']")

    private static WebElement passwdLoginInputField;
    @FindBy(xpath = "//*[@data-qa='login-button']")
    private static WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getSignupForm() {
        return signupForm;
    }
    public WebElement getNameInputSignupField() {
        return nameInputSignupField;
    }
    public WebElement getEmailSignupInputField() {
        return emailSignupInputField;
    }
    public WebElement getSignupButton() {
        return signupButton;
    }
    public WebElement getEmailLoginInputField() {
        return emailLoginInputField;
    }
    public WebElement getPasswdLoginInputField() {
        return passwdLoginInputField;
    }
    public WebElement getLoginButton() {
        return loginButton;
    }




    public String getBASE_URL() {
        return BASE_URL;
    }

}
