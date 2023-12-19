package ua.foxminded.skarb.test;

import dev.failsafe.internal.util.Assert;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Volunteer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class VolunteerCreationPageTestWithRandomGeneratedData {
    Properties properties;
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        properties = TestUtilities.loadProperties("config.properties");
    }

    @Test
    public void randomVolunteerRegTest(){
        driver = TestUtilities.getDriver("chrome");
        Volunteer volunteer = Instancio.create(Volunteer.class);
        registrationTest(volunteer);
        Assertions.assertEquals(volunteer.getPassword(), volunteer.getConfirmPassword());
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

        WebElement genderDropdown = driver.findElement(By.name("sex"));
        Select genDropdown = new Select(genderDropdown);

        WebElement languageDropdown = driver.findElement(By.name("sex"));
        Select langDropdown = new Select(languageDropdown);

        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));
        WebElement descriptionField = driver.findElement(By.id("about"));

        WebElement categoryDropdown = driver.findElement(By.id("categories"));
        Select catDropdown = new Select(categoryDropdown);

        WebElement submitButton = driver.findElement(By.name("submit"));

        firstNameField.sendKeys(volunteer.getFirstName());
        lastNameField.sendKeys(volunteer.getLastName());
        phoneField.sendKeys(volunteer.getPhone());
        passwordField.sendKeys(volunteer.getPassword());
        confirmPasswordField.sendKeys(volunteer.getConfirmPassword());

        System.out.println(volunteer.getPassword());
        System.out.println(volunteer.getConfirmPassword());


    }
}
