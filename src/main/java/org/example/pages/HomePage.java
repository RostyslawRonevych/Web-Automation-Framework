package org.example.pages;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

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

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;



public class HomePage {
    Properties properties;
    List<String> browsers;
    WebDriver driver;
    @BeforeEach
    public void setUp() {
        properties = loadProperties("config.properties");
        //      Commented to keep the code here before deletion
        //      getBrowsers();
    }


    @ParameterizedTest
    @ValueSource(strings = {"chrome", "firefox"})
    public void loginTests(String browserName) {
        loginTest(browserName);
    }

    //      Commented to keep the code here before deletion
//    @Test
//    public void mozillaLoginTests() {
//        loginTest(browsers.get(1));
//    }

    @AfterEach
    public void finish(){
        driver.quit();
    }

    private void loginTest(String browser) {
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        String targetUrl = properties.getProperty("homepageUrl");

        driver = getDriver(browser);

        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Вхід"));

        WebElement loginInputField = driver.findElement(By.xpath("//*[@id='login']"));
        loginInputField.sendKeys(login);

        WebElement passwordInputField = driver.findElement(By.xpath("//*[@id='password']"));
        passwordInputField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();

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
//      Commented to keep the code here before deletion
//    public void getBrowsers() {
//        Properties properties = loadProperties("config.properties");
//        String browserList = properties.getProperty("browsers");
//        browsers = Arrays.asList(browserList.split(","));
//    }

    private static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        try (InputStream input = HomePage.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + fileName);
                return properties;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }
}

