package ua.foxminded.skarb.test;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class VolunteerCreationPageTest {
    Properties properties;
    List<String> browsers;
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        properties = loadProperties("config.properties");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/volunteers_provider.csv", numLinesToSkip = 1)
    public void firefoxVolunteerRegTests(String caseName, String firstName, String lastName, String mailtype, String phone, int gender, int language, String password, String confirmPassword, String description, int category, String caseType) throws IOException {
        driver = getDriver("firefox");
        volunteerRegistrationTest(caseName, firstName, lastName, mailtype, phone, gender, language, password, confirmPassword, description, category, caseType);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/volunteers_provider.csv", numLinesToSkip = 1)
    public void chromeVolunteerRegTests(String caseName, String firstName, String lastName, String mailtype, String phone, int gender, int language, String password, String confirmPassword, String description, int category, String caseType) throws IOException {
        driver = getDriver("chrome");
        volunteerRegistrationTest(caseName, firstName, lastName, mailtype, phone, gender, language, password, confirmPassword, description, category, caseType);
    }

    private void volunteerRegistrationTest(String caseName, String firstName, String lastName, String mailtype, String phone, int gender, int language, String password, String confirmPassword, String description, int category, String caseType) throws IOException {
        String mailHogUrl = properties.getProperty("mailUrl");
        String volunteerRegPage = properties.getProperty("volunteerRegistrationPage");

        if ("NULL".equals(firstName)) {
            firstName = "";
        }
        if ("NULL".equals(lastName)) {
            lastName = "";
        }
        if ("NULL".equals(phone)) {
            phone = "";
        }
        if ("NULL".equals(password)) {
            password = "";
        }
        if ("NULL".equals(confirmPassword)) {
            confirmPassword = "";
        }
        if ("NULL".equals(description)) {
            description = "";
        }

//        driver = getDriver(browser);

        driver.get(volunteerRegPage);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("registration-form")));

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement phoneField = driver.findElement(By.id("phoneNumber"));

        WebElement genderDropdown = driver.findElement(By.name("sex"));
        Select genDropdown = new Select(genderDropdown);

        WebElement languageDropdown = driver.findElement(By.id("language"));
        Select langDropdown = new Select(languageDropdown);

        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));
        WebElement descriptionField = driver.findElement(By.id("about"));

        WebElement categoryDropdown = driver.findElement(By.id("categories"));
        Select catDropdown = new Select(categoryDropdown);

        WebElement submitButton = driver.findElement(By.name("submit"));

        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(generateMail(mailtype));
        phoneField.sendKeys(phone);
        genDropdown.selectByIndex(gender);
        langDropdown.selectByIndex(language);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        descriptionField.sendKeys(description);
        catDropdown.selectByIndex(category);

        submitButton.click();

        WebElement successMessage = null;
        try {
            successMessage = driver.findElement(By.name("message"));
        } catch (NoSuchElementException e) {
            // If the element is not found, proceed as needed for Negative case
        }

        if (caseType.equals("Positive")) {
            Assertions.assertTrue(successMessage != null && successMessage.isDisplayed());
        } else if (caseType.equals("Negative")) {
            Assertions.assertTrue(successMessage == null || !successMessage.isDisplayed());
        }
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
        try (InputStream input = HomePageTest.class.getClassLoader().getResourceAsStream(fileName)) {
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

    public static String generateMail(String mailType) throws IOException {
        String email = "";
        if (mailType.equals("valid")) {
            Properties properties = new Properties();

            FileInputStream fileInputStream = new FileInputStream("src\\main\\resources\\config.properties");
            properties.load(fileInputStream);
            fileInputStream.close();

            String lastUsedMail = properties.getProperty("lastUsedMail");
            int lastMailNumber = Integer.parseInt(lastUsedMail);
            email = "skarbmail" + lastUsedMail + "@mailinator.com";

            lastMailNumber++;

            properties.setProperty("lastUsedMail", String.valueOf(lastMailNumber));

            FileOutputStream fileOutputStream = new FileOutputStream("src\\main\\resources\\config.properties");
            properties.store(fileOutputStream, null);
            fileOutputStream.close();
        }
        else if (mailType.equals("invalid")) {
            email = "invalidMail";
        }
        else if (mailType.equals("registered")) {
            email = "skarbmail10@mailinator.com";
        }
        else if (mailType.equals("empty")) {
            email = "";
        }
        else {
            System.out.println("Invalid mailtype argument");
        }

        return email;
    }

    @AfterEach
    public void finish(){
        driver.quit();
    }
}
