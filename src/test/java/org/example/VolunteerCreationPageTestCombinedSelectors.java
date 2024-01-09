package org.example;

import org.instancio.junit.InstancioExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.ui.Select;
import utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Model.Volunteer;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

@ExtendWith(InstancioExtension.class)
public class VolunteerCreationPageTestCombinedSelectors {
    Properties properties;
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        properties = TestUtilities.loadProperties("config.properties");
    }

    @ParameterizedTest
    @MethodSource("Model.Volunteer#createVolunteerStreamValid")
    public void randomVolunteerRegTest(Volunteer volunteer) {
        driver = TestUtilities.getDriver("chrome");
        registrationTest(volunteer);
    }

    private void registrationTest(Volunteer volunteer) {
        String volunteerRegPage = properties.getProperty("volunteerRegistrationPage");
        driver.get(volunteerRegPage);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("registration-form")));

        List<WebElement> personalData = driver.findElements(By.xpath("//*[@id='firstName' or @id='lastName']"));
        WebElement emailField = driver.findElement(By.xpath("//*[@id='email']"));
        List<WebElement> passwords = driver.findElements(By.cssSelector("input[type=password]"));
        List<WebElement> dropdownDiv = driver.findElements(By.cssSelector("select.colorful-select"));
        WebElement submitButton = driver.findElement(By.name("submit"));

        for (WebElement personalDatum : personalData) {
            personalDatum.sendKeys(volunteer.getFirstName());
        }

        emailField.sendKeys(volunteer.getEmail());

        for (WebElement tempPass : passwords){
            tempPass.sendKeys(volunteer.getPassword());
        }

        for (WebElement tempDropdowns : dropdownDiv){
            Select dropdownField = new Select(tempDropdowns);
            dropdownField.selectByIndex(volunteer.getGender());
        }

        submitButton.click();

        WebElement successMessage = null;
        try {
            successMessage = driver.findElement(By.name("message"));
        } catch (NoSuchElementException e) {
            // If the element is not found, proceed as needed for Negative case
        }

        Assertions.assertTrue(successMessage != null && successMessage.isDisplayed());
    }
}