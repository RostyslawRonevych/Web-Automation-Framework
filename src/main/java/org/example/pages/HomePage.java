package org.example.pages;

import org.junit.Test;
import org.junit.Assert;
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

    @Test
    public void runBrowserTests() {
        Properties properties = loadProperties("config.properties");
        String browserList = properties.getProperty("browsers");
        List<String> browsers = Arrays.asList(browserList.split(","));

        for (String browser : browsers) {
            browserSetUp(browser, properties);
        }
    }

    private void browserSetUp(String browser, Properties properties) {
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");

        WebDriver driver = getDriver(browser);

        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Вхід"));

        WebElement loginField = driver.findElement(By.xpath("//*[@id=\"login\"]"));
        loginField.sendKeys(login);

        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.xpath("/html/body/div[3]/div/section/div/div/div/div/div/form/div[3]/button"));
        loginButton.click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://skarb.foxminded.ua/");

        System.out.println(browser + " test finished");

        driver.quit();
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

