package org.example.pages;

import org.junit.Test;
import static org.junit.Assert.*;
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
import java.util.List;
import java.util.Properties;
import java.util.Set;


public class HomePage {

    public void main(String[] args) {

        try {
            chromeSetUp();
        } finally {
            System.out.println("Chrome test failed");
        }

        try {
            fireFoxSetUp();
        } finally {
            System.out.println("Firefox test failed");
        }
    }

    @Test
    public void chromeSetUp(){
        Properties properties = loadProperties("config.properties");

        // Read URL from the properties file
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");

        // Create a new instance of the ChromeDriver
        WebDriver chDriver = new ChromeDriver();
        chDriver.get(url);

        // Wait for the title of the page to contain "Example Domain" within 10 seconds
        WebDriverWait wait = new WebDriverWait(chDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Вхід"));

        // Perform actions after the condition is met
        WebElement loginField = chDriver.findElement(By.xpath("//*[@id=\"login\"]"));
        loginField.findElement(By.xpath("//*[@id=\"login\"]")).sendKeys(login);

        WebElement passwordField = chDriver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordField.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);

        WebElement button = chDriver.findElement(By.xpath("/html/body/div[3]/div/section/div/div/div/div/div/form/div[3]/button"));
        button.click();

        String currentUrl = chDriver.getCurrentUrl();

        assertEquals(currentUrl, "https://skarb.foxminded.ua/");

        System.out.println("Chrome test finished");

        chDriver.quit();
    }

    @Test
    public void fireFoxSetUp(){
        Properties properties = loadProperties("config.properties");

        // Read URL from the properties file
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");

        // Create a new instance of the FireFoxDriver
        WebDriver foxDriver = new FirefoxDriver();
        foxDriver.get(url);

        // Wait for the title of the page to contain "Example Domain" within 10 seconds
        WebDriverWait wait = new WebDriverWait(foxDriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Вхід"));

        // Perform actions after the condition is met
        WebElement loginField = foxDriver.findElement(By.xpath("//*[@id=\"login\"]"));
        loginField.findElement(By.xpath("//*[@id=\"login\"]")).sendKeys(login);

        WebElement passwordField = foxDriver.findElement(By.xpath("//*[@id=\"password\"]"));
        passwordField.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);

        WebElement button = foxDriver.findElement(By.xpath("/html/body/div[3]/div/section/div/div/div/div/div/form/div[3]/button"));
        button.click();

        String currentUrl = foxDriver.getCurrentUrl();

        assertEquals(currentUrl, "https://skarb.foxminded.ua/");

        System.out.println("Firefox test finished");

        foxDriver.quit();
    }

    private static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        try (InputStream input = HomePage.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                System.out.println("Sorry, unable to find " + fileName);
                return properties;
            }
            // load a properties file from class path, inside static method
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }
}
