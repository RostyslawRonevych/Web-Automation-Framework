package org.example;

import org.example.Model.BeyondAccount;
import org.openqa.selenium.JavascriptExecutor;
import org.instancio.junit.InstancioExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.*;
import utilities.TestUtilities;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Properties;


@ExtendWith(InstancioExtension.class)
    public class BeyondTest {
        static Properties properties;
        static WebDriver driver;

        @BeforeAll
        public static void setUp() {
            properties = TestUtilities.loadProperties("config.properties");
            driver = TestUtilities.getDriver("chrome");
        }

        @ParameterizedTest
        @MethodSource("org.example.Model.BeyondAccount#createBeyondStreamValid")
        public void accountRegTest(BeyondAccount beyond) {
            registrationTest(beyond);
        }

        private void registrationTest(BeyondAccount beyond) {
            String regPage = properties.getProperty("beyondRegUrl");
            driver.get(regPage);

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='auth_container']")));

            driver.manage().window().maximize();

            List<WebElement> inputs = driver.findElements(By.tagName("input"));
            List<WebElement> checkbox = driver.findElements(By.xpath("//div[@class='auth_checkbox']"));
            System.out.println(inputs.size());

            inputs.get(0).sendKeys(beyond.getName());
            inputs.get(1).sendKeys(beyond.getEmail());
            inputs.get(2).sendKeys(beyond.getPhone());
            inputs.get(3).sendKeys(beyond.getPassword());
            inputs.get(4).sendKeys(beyond.getPassword());
            checkbox.get(0).click();

            System.out.println(beyond.getEmail());

            WebElement submitButton = driver.findElement(By.cssSelector("button.register_btn"));

            JavascriptExecutor executor = (JavascriptExecutor) driver;

            executor.executeScript("arguments[0].click();", submitButton);

            WebDriverWait dialogWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            dialogWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog']")));

        }

        @AfterAll
        public static void cleanUp() {
            driver.quit();
        }
    }

