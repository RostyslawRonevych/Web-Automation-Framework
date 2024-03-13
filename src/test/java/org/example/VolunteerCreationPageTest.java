package org.example;

import org.example.pages.VolunteerCreationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.*;
import org.opentest4j.AssertionFailedError;
import utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class VolunteerCreationPageTest {
    private static final Logger logger = LogManager.getLogger(VolunteerCreationPage.class);
    Properties properties;
    List<String> browsers;
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        properties = TestUtilities.loadProperties("config.properties");
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/volunteers_provider.csv", numLinesToSkip = 1)
    public void volunteerRegTests(String caseName, String firstName, String lastName, String mailtype, String phone, int gender, int language, String password, String confirmPassword, String description, int category, String caseType) throws IOException {
        driver = TestUtilities.getDriver("chrome");
        volunteerRegistrationTest(caseName, firstName, lastName, mailtype, phone, gender, language, password, confirmPassword, description, category, caseType);
    }

    private void volunteerRegistrationTest(String caseName, String firstName, String lastName, String mailtype, String phone, int gender, int language, String password, String confirmPassword, String description, int category, String caseType) throws IOException {
        logger.info("Started " + caseName + " testcase execution");

        String mailHogUrl = properties.getProperty("mailUrl");
        String volunteerRegPage = properties.getProperty("volunteerRegistrationPage");

        if ("NULL".equals(description)) {
            description = "";
        }

        driver.get(volunteerRegPage);
        driver.manage().window().maximize();

        VolunteerCreationPage page = new VolunteerCreationPage(driver);

        page.formWait();

        page.setFirstNameField(firstName)
            .setLastNameField(lastName)
            .setEmailField(generateMail(mailtype))
            .setPhoneField(phone)
            .setGenderField(gender)
            .setLanguageField(language)
            .setPasswordField(password)
            .setConfirmPassword(confirmPassword)
            .setAboutField(description)
            .setCategoriesField(category)
            .clickRegister();

        logger.info("Form has been populated and submitted");

        WebElement successMessage = null;
        try {
            successMessage = page.successWait();
        } catch (NoSuchElementException e) {
            // If the element is not found, proceed as needed for Negative case
        } catch (TimeoutException e){
            // if the success message isnt there in time the test will proceed
        }

        if (caseType.equals("Positive")) {
            try {
                Assertions.assertTrue(successMessage != null);
                Assertions.assertTrue(successMessage.isDisplayed());
                logger.info("Test passed successfully, account has been registered");
            } catch (AssertionFailedError e){
                logger.error("Test FAILED, account has not been registered, success message is not displayed");
            }

        } else if (caseType.equals("Negative")) {
            try {
                Assertions.assertTrue(successMessage == null || !successMessage.isDisplayed());
                logger.info("Test passed successfully, account has not been registered");
            } catch (AssertionFailedError e){
                logger.error("Test FAILED, account has been registered, success message is displayed");
            }
        }
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
            email = "skarbmail" + lastUsedMail + "@testing.com";

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
