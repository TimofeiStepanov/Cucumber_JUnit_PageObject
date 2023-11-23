package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateAccountMessage extends BasePage{

    public CreateAccountMessage(WebDriver driver) {
        super(driver);
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
