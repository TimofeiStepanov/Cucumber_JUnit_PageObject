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
    private static WebElement accCreateH2Text;
    @FindBy(xpath = "//*[@data-qa='continue-button']")
    private static WebElement continueButton;

    public WebElement getAccCreateH2Text() {
        return accCreateH2Text;
    }
    public WebElement getContinueButton() {
        return continueButton;
    }

}
