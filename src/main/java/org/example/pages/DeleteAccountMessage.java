package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteAccountMessage {
    final WebDriver driver;

    public DeleteAccountMessage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@data-qa='account-deleted']")
    private static WebElement accountDeleteMessage;
    @FindBy(xpath = "//*[@data-qa='continue-button']")
    private static WebElement continueButton;

    public WebElement getAccountDeleteMessage() {
        return accountDeleteMessage;
    }
    public WebElement getContinueButton() {
        return continueButton;
    }

}
