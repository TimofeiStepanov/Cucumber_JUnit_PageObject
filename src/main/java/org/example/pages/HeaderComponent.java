package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderComponent{
    final WebDriver driver;

    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@href=\'/login\']")
    WebElement login;





    public void loginButtonPresent(){
        Wait<WebDriver> wait;
        wait = new WebDriverWait((WebDriver) driver, Duration.ofSeconds(5));
        wait.until(d -> login.isDisplayed());
    }

    public void clickLogin() {

        login.click();
    }
}
