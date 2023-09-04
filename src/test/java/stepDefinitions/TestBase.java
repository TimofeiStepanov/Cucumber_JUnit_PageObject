package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {

    public static WebDriver driver;

    @BeforeAll
    public static void setupDriverClass() {
            //save driver to path: win "C:\Users\%USER_NAME%\.cache\selenium\chromedriver\"
            //                     unix "~/.cache/selenium/chromedriver"
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.safaridriver().setup();
    }
    @BeforeAll
    public static WebDriver initializeDriver() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
                return driver;
    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }



}
