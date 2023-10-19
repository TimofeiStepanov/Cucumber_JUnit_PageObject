package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBar {
    WebDriver driver;
    //    private final String baseUrl = "https://automationexercise.com/delete_account";
    //PAGE LOCATORS
    @FindBy(xpath = "//li/a[text()=' Home']")
    private static WebElement homeLink;
    @FindBy(xpath = "//*[@href='/login']")
    private static WebElement loginLink;
    @FindBy(xpath = "//*[@href='/logout']")
    WebElement logoutButtonLink;
    @FindBy(xpath = "//*[@href='/delete_account']")
    WebElement deleteAccountLink;
    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[5]/a")
    WebElement loggedText;
    @FindBy(xpath = "//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a/b")
    WebElement loggedName;
    @FindBy(xpath = "//li/a[text()=' Logged in as ']")
    private static WebElement loggedLink;
    public NavigationBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getHomeLink() {
        return homeLink;
    }
    public WebElement getLoginLink() {
        return loginLink;
    }
    public WebElement getLoggedLink() {
        return loggedLink;
    }

    //PAGE ACTIONS
    public boolean loginButtonDisplayed() {
        return loginLink.isDisplayed();
    }

    public void clickLogin() {

        loginLink.click();
    }

    public String loggedNameGet() {
        return loggedName.getText();
    }

    public void deleteAccount() {
        deleteAccountLink.click();
    }


    public void logoutClick() {
        logoutButtonLink.click();
    }

    public void deleteAccountClick() {
        deleteAccountLink.click();
        String url = driver.getCurrentUrl();
        if (url.equals("https://automationexercise.com/#google_vignette")) {
            driver.get("https://automationexercise.com/delete_account");
        }
    }
}
