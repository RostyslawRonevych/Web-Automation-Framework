package ua.foxminded.skarb.test;

import org.instancio.junit.InstancioExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.MethodSource;
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
import java.util.Properties;

@ExtendWith(InstancioExtension.class)
public class VolunteerCreationPageTestWithRandomGeneratedData {
    Properties properties;
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        properties = TestUtilities.loadProperties("config.properties");
    }

    @ParameterizedTest
    @MethodSource("Model.Volunteer#createVolunteerStreamValid")
    public void randomVolunteerRegTest(Volunteer volunteer){
        driver = TestUtilities.getDriver("chrome");
        registrationTest(volunteer);
    }

    private void registrationTest(Volunteer volunteer){
        String volunteerRegPage = properties.getProperty("volunteerRegistrationPage");
        driver.get(volunteerRegPage);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("registration-form")));

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement phoneField = driver.findElement(By.id("phoneNumber"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));
        WebElement submitButton = driver.findElement(By.name("submit"));

        firstNameField.sendKeys(volunteer.getFirstName());
        lastNameField.sendKeys(volunteer.getLastName());
        emailField.sendKeys(volunteer.getEmail());
        phoneField.sendKeys(volunteer.getPhone());
        passwordField.sendKeys(volunteer.getPassword());
        confirmPasswordField.sendKeys(volunteer.getPassword());

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
