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

    public void setFirstNameField(String firstName) {
        firstNameFieldElement.sendKeys(firstName);
    }

    public void setLastNameField(String lastName) {
        lastNameFieldElement.sendKeys(lastName);
    }

    public void setEmailField(String email) {
        emailFieldElement.sendKeys(email);
    }

    public void setPhoneField(String phone) {
        phoneNumberFieldElement.sendKeys(phone);
    }

    public void setGenderField(int gender) {
        sexDropdownSelect.selectByIndex(gender);
    }

    public void setLanguageField(int language) {
        languageDropdownSelect.selectByIndex(language);
    }

    public void setPasswordField(String password) {
        passFieldElement.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        confirmPassFieldElement.sendKeys(confirmPassword);
    }

    public void setAboutField (String about) {
        aboutFieldElement.sendKeys(about);
    }

    public void setCategoriesField(int categories) {
        categoriesDropdownSelect.selectByIndex(categories);
    }

    public void clickRegister() {
        registerButton.click();
    }

    public void getPasswordText(){
        passFieldElement.getText();
    }

    public void formWait(){
        wait = baseTest.waitCreate(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("registration-form")));
    }

    public void successWait(){
        wait = baseTest.waitCreate(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("message")));
    }

}