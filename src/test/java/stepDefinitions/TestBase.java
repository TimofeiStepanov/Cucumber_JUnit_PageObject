package stepDefinitions;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
    public WebDriver driver;
    @BeforeAll
    static void setupDriverClass() {
            //save driver to path: win "C:\Users\%USER_NAME%\.cache\selenium\chromedriver\"
            //                     unix "~/.cache/selenium/chromedriver"
        WebDriverManager.chromedriver().setup();
            //TO DO:save driver to custom path.
            //Now need :
            // 1) Open : External Libraries --> Maven:io.github.bonigarcia:webdrivermanager:5.2.2 -->
            //           --> webdrivermanager.properties
            // 2) Change : wdm.cachePath=~/.cache/selenium/ to your custom path

    }
    @NotNull
    @BeforeAll
    public static WebDriver initializeDriver() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }
    @AfterEach
    void teardown() {
        driver.quit();
    }



}
