package org.example.pages;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage{
    final WebDriver driver;
    private static final String BASE_URL = "https://automationexercise.com/";
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public String getBASE_URL(){
        return BASE_URL;
    }

}








