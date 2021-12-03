package baseTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


@ExtendWith(TestResultLogger.class)
public class Base {
    protected static WebDriver driver;
    protected static WebDriverWait webDriverWait;
    protected String baseUrl = "https://www.gittigidiyor.com/";

    @BeforeEach

    public void driverConfig() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("disable-popup-blocking");
        System.setProperty("webdriver.chrome.driver", "C:/Users/testinium/IdeaProjects/project1/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @AfterEach
    public void close() {
        driver.quit();
    }
}
