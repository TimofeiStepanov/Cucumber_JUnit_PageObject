package org.example.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToHomePage() {
        driver.get("http://automationexercise.com");
    }

}

    //static String baseUrl = "https://automationexercise.com";





