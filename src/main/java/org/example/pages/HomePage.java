package org.example.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class HomePage {


    WebDriver driver;
    String BaseUrl = "https://automationexercise.com";
    //constructor
    public HomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //Locators




    //Methods
    public void goToHomePage(){
        driver.get(BaseUrl);

    }

     public void tearDown() {
        driver.quit();
    }


}
