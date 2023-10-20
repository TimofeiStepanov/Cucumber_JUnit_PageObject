package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateAccountMessage {
    final WebDriver driver;

    public CreateAccountMessage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@data-qa='account-created']")
    private static WebElement accountCreateH2Text;
    @FindBy(xpath = "//*[@data-qa='continue-button']")
    private static WebElement continueButton;

    public WebElement getAccountCreateH2Text() {
        return accountCreateH2Text;
    }
    public WebElement getContinueButton() {
        return continueButton;
    }

}
