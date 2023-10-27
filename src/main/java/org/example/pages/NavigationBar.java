package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBar {
    WebDriver driver;

    @FindBy(xpath = "//li/a[text() = ' Home']")
    private static WebElement homeLink;
    @FindBy(xpath = "//*[@href = '/login']")
    private static WebElement loginLink;
    @FindBy(xpath = "//*[@href = '/logout']")
    private static WebElement logoutLink;
    @FindBy(xpath = "//*[@href = '/delete_account']")
    private static WebElement deleteAccountLink;
    @FindBy(xpath = "//li/a[text() = ' Logged in as ']/b")
    private static WebElement loggedName;
    @FindBy(xpath = "//li/a[text() = ' Logged in as ']")
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

    public WebElement getLoggedName() {
        return loggedName;
    }

    public WebElement getLogoutLink() {
        return logoutLink;
    }
    public WebElement getDeleteAccountLink() {
        return deleteAccountLink;
    }









}
