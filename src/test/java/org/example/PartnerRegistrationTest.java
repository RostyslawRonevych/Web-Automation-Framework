package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Model.Partner;
import org.example.pages.HomePage;
import org.example.pages.MailPage;
import org.example.pages.PartnerCreationPage;
import org.instancio.junit.InstancioExtension;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.*;
import utilities.TestUtilities;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Properties;
import java.util.Set;

@ExtendWith(InstancioExtension.class)
public class PartnerRegistrationTest {
    private static final Logger logger = LogManager.getLogger(PartnerRegistrationTest.class);
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
        String homePageUrl = properties.getProperty("homepageUrl");
        driver.get(homePageUrl);

        driver.manage().window().maximize();

        HomePage homePage = new HomePage(driver);

        homePage.navRegButtonClick();
        homePage.partnerButtonClick();

        PartnerCreationPage partnerPage = new PartnerCreationPage(driver);

        partnerPage.formWait();

        partnerPage.setFirstNameField(partner.getFirstName());
        partnerPage.setLastNameField(partner.getLastName());
        partnerPage.setEmailField(partner.getEmail());
        logger.info(partner.getEmail());
        partnerPage.setPhoneField(partner.getPhone());
        partnerPage.setPasswordField(partner.getPassword());
        logger.info(partner.getPassword());
        partnerPage.setConfirmPassword(partner.getPassword());
        if(partner.getSex() == 1){
            partnerPage.setGenderFemale();
        }
        else if (partner.getSex() == 2) {
           partnerPage.setGenderMale();
        }
        partnerPage.setOrganizationName(partner.getOrganizationName());
        partnerPage.setCategoriesField(partner.getCategories());
        partnerPage.setPositionElement(partner.getPosition());
        partnerPage.setAboutElement(partner.getAbout());

        partnerPage.registerClick();

        String mailPage = properties.getProperty("mailUrl");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(mailPage);

        String email = partner.getEmail();

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
    }

    @AfterAll
    public static void cleanUp(){
        driver.quit();
    }
}
