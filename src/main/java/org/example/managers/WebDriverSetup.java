package org.example.managers;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSetup {

    WebDriver driver;

    public static WebDriver initializeDriver() {

        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.safaridriver().setup();




        String webdriver = System.getProperty("browser","edge");
        switch(webdriver) {
            case "firefox" -> {
                WebDriver driver = new FirefoxDriver();
                driver.manage().window().maximize();
                return driver;
            }
            case "chrome" -> {
                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                return driver;
            }
            case "edge" -> {
                WebDriver driver = new EdgeDriver();
                driver.manage().window().maximize();
                return driver;
            }
//            case "safari" -> {
//                driver = new SafariDriver();
//                driver.manage().window().maximize();
//                return driver;
//            }
            default -> throw new RuntimeException("Unsupported webdriver: " + webdriver);
        }
    }
    public void tearDown(){
        driver.quit();
    }
}
