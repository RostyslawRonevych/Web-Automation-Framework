package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class VolunteerCreationPage {

    WebDriver driver;

    @FindBy(id = "firstName")
    private WebElement firstNameFieldElement;

    @FindBy(id = "lastName")
    private WebElement lastNameFieldElement;

    @FindBy(id = "email")
    private WebElement emailFieldElement;

    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberFieldElement;

    @FindBy(name = "sex")
    private Select genderDropdownElement = new Select(driver.findElement(By.name("sex")));

    @FindBy(id = "language")
    private Select languageDropdownElement = new Select(driver.findElement(By.id("language")));

    @FindBy(id = "password")
    private WebElement passFieldElement;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPassFieldElement;

    @FindBy(id = "about")
    private WebElement aboutFieldElement;

    @FindBy(id = "language")
    private Select categoriesDropdownElement = new Select(driver.findElement(By.id("categories")));

    @FindBy(name = "submit")
    private WebElement registerButton;

    public VolunteerCreationPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
        genderDropdownElement.selectByIndex(gender);
    }

    public void setLanguageField(int language) {
        languageDropdownElement.selectByIndex(language);
    }

    public void setPasswordField(String password) {
        passFieldElement.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        confirmPassFieldElement.sendKeys(confirmPassword);
    }

    public void setAboutField (String about) {
        confirmPassFieldElement.sendKeys(about);
    }

    public void setCategoriesField(int categories) {
        languageDropdownElement.selectByIndex(categories);
    }

    public void clickRegister() {
        registerButton.click();
    }

    // Additional methods for validation, navigation, etc., can be added here
}