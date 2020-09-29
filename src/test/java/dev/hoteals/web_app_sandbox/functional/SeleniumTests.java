package dev.hoteals.web_app_sandbox.functional;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class SeleniumTests
{
    // These 2 tests are not supposed to run as part of normal CI and `mvn` test due to being excluded in the pom.xml
    // in order to run them, you must use `mvn -Dtest=dev.hoteals.web_app_sandbox.functional.** test`
    @Test
    public void validTest()
    {
        assertThat(true).isEqualTo(true);
    }

    @Test
    @Disabled
    public void invalidTest()
    {
        assertThat(true).isEqualTo(false);
    }

    private static WebDriver webDriver;

    @BeforeAll
    public static void setup()
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless");
        webDriver = new ChromeDriver(options);
        webDriver.get("http://localhost:5000");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void getIndexTitleTest()
    {
        webDriver.get("http://localhost:5000");
        assertThat(webDriver.getTitle()).isEqualTo("Person");
    }

    @AfterAll
    public static void cleanup()
    {
        if (webDriver != null)
        {
            webDriver.quit();
        }
    }
}
