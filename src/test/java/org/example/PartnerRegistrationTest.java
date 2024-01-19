package org.example;

import org.example.Model.Partner;
import org.instancio.junit.InstancioExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.*;
import utilities.TestUtilities;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(InstancioExtension.class)
public class PartnerRegistrationTest {
    static Properties properties;
    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        properties = TestUtilities.loadProperties("config.properties");
        driver = TestUtilities.getDriver("chrome");
    }

    @ParameterizedTest
    @MethodSource("org.example.Model.Partner#createPartnerStreamValid")
    public void randomPartnerRegTest(Partner partner) {
        registrationTest(partner);
    }

    private void registrationTest(Partner partner) {
        String homePage = properties.getProperty("homepageUrl");
        driver.get(homePage);

        driver.manage().window().maximize();

        WebElement navRegButton = driver.findElement(By.className("ml-auto"));
        navRegButton.click();

        WebElement partnerButton = driver.findElement(By.name("partners"));
        partnerButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement phoneField = driver.findElement(By.id("phoneNumber"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement confirmPasswordField = driver.findElement(By.id("confirmPassword"));
        WebElement femaleSex = driver.findElement(By.id("female"));
        WebElement maleSex = driver.findElement(By.id("male"));
        WebElement organizationName = driver.findElement(By.id("organizationName"));

        WebElement categoryIds = driver.findElement(By.id("categoryIds"));
        Select selectCategoryIds = new Select(categoryIds);

        WebElement positionInOrganization = driver.findElement(By.id("positionInOrganization"));
        WebElement aboutOrganization = driver.findElement(By.id("aboutOrganization"));

        WebElement submitButton = driver.findElement(By.name("submit"));

        firstNameField.sendKeys(partner.getFirstName());
        lastNameField.sendKeys(partner.getLastName());
        emailField.sendKeys(partner.getEmail());
        phoneField.sendKeys(partner.getPhone());
        passwordField.sendKeys(partner.getPassword());
        confirmPasswordField.sendKeys(partner.getPassword());
        if(partner.getSex() == 1){
            femaleSex.click();
        }
        else if (partner.getSex() == 2) {
            maleSex.click();
        }
        organizationName.sendKeys(partner.getOrganizationName());
        selectCategoryIds.selectByIndex(partner.getCategories());
        positionInOrganization.sendKeys(partner.getPosition());
        aboutOrganization.sendKeys(partner.getAbout());

        submitButton.click();

        String mailPage = properties.getProperty("mailUrl");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(mailPage);

        String email = partner.getEmail();
        WebDriverWait mailWait = new WebDriverWait(driver, Duration.ofSeconds(100));
        mailWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), '"+email+"')]")));

        WebElement targetMail = driver.findElement(By.xpath("//div[contains(text(), '"+email+"')]"));
        targetMail.click();

        WebElement confirmationLink = driver.findElement(By.xpath("//a[contains(text(), 'token')]"));
        confirmationLink.click();

        Set<String> windowHandles = driver.getWindowHandles();
        Object[] handlesArray = windowHandles.toArray();
        String lastTabHandle = (String) handlesArray[2];
        driver.switchTo().window(lastTabHandle);

        WebDriverWait confirmationWait = new WebDriverWait(driver, Duration.ofSeconds(100));
        confirmationWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.alert-success")));

        WebElement confirmation = driver.findElement(By.cssSelector("div.alert-success"));

        Assertions.assertTrue(confirmation.getText().contains("Email"));
    }

//    @AfterAll
//    public static void cleanUp(){
//        driver.quit();
//    }
}
