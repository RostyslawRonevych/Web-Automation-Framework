package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Model.Organization;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.MailPage;
import org.example.pages.OrganizationCreationPage;
import org.instancio.junit.InstancioExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import utilities.TestUtilities;

import java.util.Properties;
import java.util.Set;

@ExtendWith(InstancioExtension.class)
public class OrganizationCreationTest {
    private static final Logger logger = LogManager.getLogger(OrganizationCreationTest.class);
    static Properties properties;
    static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        properties = TestUtilities.loadProperties("config.properties");
        driver = TestUtilities.getDriver("chrome");
    }

    @ParameterizedTest
    @MethodSource("org.example.Model.Organization#createOrganizationStreamValid")
    public void organizationRegTest(Organization organization) {
        registrationTest(organization);
    }

    private void registrationTest(Organization organization) {
        String homePageUrl = properties.getProperty("homepageUrl");
        driver.get(homePageUrl);

        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);

        homePage.navRegButtonClick();
        homePage.organizationsButtonClick();

        OrganizationCreationPage orgPage = new OrganizationCreationPage(driver);

        orgPage.formWait();

        orgPage.setFirstNameField(organization.getFirstName());
        orgPage.setLastNameField(organization.getLastName());
        orgPage.setEmailField(organization.getEmail());
        logger.info(organization.getEmail());
        orgPage.setPhoneField(organization.getPhone());
        orgPage.setPasswordField(organization.getPassword());
        logger.info(organization.getPassword());
        orgPage.setConfirmPassword(organization.getPassword());
        if(organization.getSex() == 1){
            orgPage.setGenderFemale();
        }
        else if (organization.getSex() == 2) {
            orgPage.setGenderMale();
        }
        orgPage.setOrganizationName(organization.getOrganizationName());
        orgPage.setCategoriesField(organization.getCategories());
        orgPage.setPositionElement(organization.getPosition());
        orgPage.setAboutElement(organization.getAbout());

        orgPage.registerClick();

        String mailPage = properties.getProperty("mailUrl");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(mailPage);

        String email = organization.getEmail();

        MailPage mailHogPage  = new MailPage(driver);

        mailHogPage.emailWait(email);

        mailHogPage.targetMailClick(email);
        mailHogPage.confirmationLinkClick();

        Set<String> windowHandles = driver.getWindowHandles();
        Object[] handlesArray = windowHandles.toArray();
        String lastTabHandle = (String) handlesArray[2];
        driver.switchTo().window(lastTabHandle);

        mailHogPage.successWait();

        Assertions.assertTrue(mailHogPage.getSuccessMessage().contains("Email"));

        String skarbHandle = (String) handlesArray[0];
        driver.switchTo().window(skarbHandle);

        orgPage.loginButtonClick();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(organization.getEmail(), organization.getPassword());
    }

//    @AfterAll
//    public static void cleanUp(){
//        driver.quit();
//    }
}
