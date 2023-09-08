package stepDefinitions;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {

    public WebDriver driver;

    @BeforeAll

    public static WebDriver initializeDriver() {

//        WebDriverManager.chromedriver().setup();
//        WebDriverManager.edgedriver().setup();
        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.safaridriver().setup();



//        WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
//        WebDriver driver = new EdgeDriver();
//        WebDriver driver = new SafariDriver();
            driver.manage().window().maximize();

        return driver;
    }


    @AfterAll
    public static void tearDown() {
      initializeDriver().quit();
    }


}
