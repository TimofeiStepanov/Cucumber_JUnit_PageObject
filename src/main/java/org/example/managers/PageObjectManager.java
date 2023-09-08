package org.example.managers;

import org.example.pages.HeaderComponent;
import org.example.pages.HomePage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;
    private HomePage homePage;
    private HeaderComponent headerComponent;

    public PageObjectManager(WebDriver driver){
        this.driver =driver;
    }

    public PageObjectManager(HomePage homePage) {

        this.homePage = homePage;
    }
    public PageObjectManager(HeaderComponent headerComponent){
        this.headerComponent = headerComponent;
    }


    public HomePage getHomePage() {

        return (homePage == null) ?
                homePage = new HomePage(driver) : homePage;
    }
    public HeaderComponent getHeaderComponent() {
        return (headerComponent == null) ?
                headerComponent = new HeaderComponent(driver) : headerComponent;
    }


}
