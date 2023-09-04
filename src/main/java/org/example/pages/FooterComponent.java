package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FooterComponent {
    final WebDriver driver;
    public FooterComponent(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



}
