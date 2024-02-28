package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VolunteerCreationPage {

    WebDriver driver;
    WebDriverWait wait;
    BaseTest baseTest = new BaseTest();

    @FindBy(id = "firstName")
    private WebElement firstNameFieldElement;

    @FindBy(id = "lastName")
    private WebElement lastNameFieldElement;

    @FindBy(id = "email")
    private WebElement emailFieldElement;

    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberFieldElement;

    @FindBy(xpath = "//select[@id='sex']")
    private WebElement genderDropdownElement;
    private Select sexDropdownSelect;
    @FindBy(xpath = "//select[@id='language']")
    private WebElement languageDropdownElement;
    private Select languageDropdownSelect;

    @FindBy(id = "password")
    private WebElement passFieldElement;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPassFieldElement;

    @FindBy(id = "about")
    private WebElement aboutFieldElement;

    @FindBy(xpath = "//select[@id='categories']")
    private WebElement categoriesDropdownElement;
    private Select categoriesDropdownSelect;

    @FindBy(name = "submit")
    private WebElement registerButton;

    public VolunteerCreationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        sexDropdownSelect = new Select(genderDropdownElement);
        languageDropdownSelect = new Select(languageDropdownElement);
        categoriesDropdownSelect = new Select(categoriesDropdownElement);
    }

    public VolunteerCreationPage setFirstNameField(String firstName) {
        firstNameFieldElement.sendKeys(firstName);
        return this;
    }

    public VolunteerCreationPage setLastNameField(String lastName) {
        lastNameFieldElement.sendKeys(lastName);
        return this;
    }

    public VolunteerCreationPage setEmailField(String email) {
        emailFieldElement.sendKeys(email);
        return this;
    }

    public VolunteerCreationPage setPhoneField(String phone) {
        phoneNumberFieldElement.sendKeys(phone);
        return this;
    }

    public VolunteerCreationPage setGenderField(int gender) {
        sexDropdownSelect.selectByIndex(gender);
        return this;
    }

    public VolunteerCreationPage setLanguageField(int language) {
        languageDropdownSelect.selectByIndex(language);
        return this;
    }

    public VolunteerCreationPage setPasswordField(String password) {
        passFieldElement.sendKeys(password);
        return this;
    }

    public VolunteerCreationPage setConfirmPassword(String confirmPassword) {
        confirmPassFieldElement.sendKeys(confirmPassword);
        return this;
    }

    public VolunteerCreationPage setAboutField (String about) {
        aboutFieldElement.sendKeys(about);
        return this;
    }

    public VolunteerCreationPage setCategoriesField(int categories) {
        categoriesDropdownSelect.selectByIndex(categories);
        return this;
    }

    public VolunteerCreationPage clickRegister() {
        registerButton.click();
        return this;
    }

    public VolunteerCreationPage getPasswordText(){
        passFieldElement.getText();
        return this;
    }

    public VolunteerCreationPage formWait(){
        wait = baseTest.waitCreate(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("registration-form")));
        return this;
    }

    public WebElement successWait(){
        wait = baseTest.waitCreate(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("message")));
        WebElement successMessage = driver.findElement(By.name("message"));
        return successMessage;
    }

}