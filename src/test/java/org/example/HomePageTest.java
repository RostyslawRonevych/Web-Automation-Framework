package org.example;

import org.example.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class HomePageTest {
    Properties properties;
    List<String> browsers;
    WebDriver driver;
    @BeforeEach
    public void setUp() {
        properties = TestUtilities.loadProperties("config.properties");
    }

    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    public void loginTests(String browserName) {
        loginTest(browserName);
    }

    private void loginTest(String browser) {
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        String targetUrl = properties.getProperty("homepageUrl");

        driver = getDriver(browser);

        driver.get(url);

        LoginPage loginPage = new LoginPage(driver);

        loginPage.formWait();
        loginPage.setLoginField(login);
        loginPage.setPasswordField(password);
        loginPage.submitButtonClick();

        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(currentUrl, targetUrl);

        System.out.println(browser + " test finished");

    }

    private static WebDriver getDriver(String browser) {
        if ("chrome".equalsIgnoreCase(browser)) {
            return new ChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browser)) {
            return new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }

    @AfterEach
    public void finish(){
        driver.quit();
    }
}

