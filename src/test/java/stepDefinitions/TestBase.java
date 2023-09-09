package stepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestBase {

    @BeforeAll

    public static WebDriver initializeDriver() {

        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.safaridriver().setup();


         WebDriver driver;

        String webdriver = System.getProperty("browser","edge");
        switch(webdriver) {
            case "firefox" -> {
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                return driver;
            }
            case "chrome" -> {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                return driver;
            }
            case "edge" -> {
                driver = new EdgeDriver();
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

    @AfterAll
    public static void tearDown() {
      initializeDriver().quit();
    }


}
