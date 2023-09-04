package org.example.managers;

import org.example.pages.FooterComponent;
import org.example.pages.HeaderComponent;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;


public class PageObjectManager {

    public WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;

    private FooterComponent footerComponent;
    private HeaderComponent headerOfAllPage;


    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public PageObjectManager(HomePage homePage) {
        this.homePage = homePage;
    }
    public  PageObjectManager(LoginPage loginPage){this.loginPage = loginPage;}

    public HomePage getHomePage() {
        return (homePage == null) ?
                homePage = new HomePage(driver) : homePage;
    }

    public LoginPage getLoginPage() {
        return (loginPage == null) ?
                loginPage = new LoginPage(driver) : loginPage;
    }
}
