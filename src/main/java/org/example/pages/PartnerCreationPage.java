package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PartnerCreationPage {
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

    @FindBy(id = "male")
    private WebElement genderMaleElement;
    @FindBy(id = "female")
    private WebElement genderFemaleElement;

    @FindBy(id = "password")
    private WebElement passFieldElement;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPassFieldElement;

    @FindBy(id = "organizationName")
    private WebElement organizationNameElement;

    @FindBy(id = "categoryIds")
    private WebElement categoriesDropdownElement;
    private Select categoriesDropdownSelect;

    @FindBy(id = "positionInOrganization")
    private WebElement positionElement;

    @FindBy(id = "aboutOrganization")
    private WebElement aboutElement;

    @FindBy(name = "submit")
    private WebElement registerButton;

    public PartnerCreationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    public void setGenderMale() {
        genderMaleElement.click();
    }

    public void setGenderFemale() {
        genderFemaleElement.click();
    }

    public void setPasswordField(String password) {
        passFieldElement.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword) {
        confirmPassFieldElement.sendKeys(confirmPassword);
    }

    public void setOrganizationName(String organizationName) {
        organizationNameElement.sendKeys(organizationName);
    }

    public void setCategoriesField(int id) {
        categoriesDropdownSelect.selectByIndex(id);
    }

    public void setAboutElement(String position){
        positionElement.sendKeys(position);
    }

    public void setPositionElement(String about){
        positionElement.sendKeys(about);
    }

    public void registerClick(){
        registerButton.click();
    }

    public void formWait(){
        wait = baseTest.waitCreate(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
    }
}
