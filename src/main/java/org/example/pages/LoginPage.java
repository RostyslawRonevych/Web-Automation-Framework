package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    BaseTest baseTest = new BaseTest();
    WebDriverWait wait;

    @FindBy(id = "login")
    private WebElement loginFieldElement;
    @FindBy(id = "password")
    private WebElement passwordFieldElement;
    @FindBy(name = "login-button")
    private WebElement submitButtonElement;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setLoginField(String firstName) {
        loginFieldElement.sendKeys(firstName);
    }

    public void setPasswordField(String password) {
        passwordFieldElement.sendKeys(password);
    }

    public void submitButtonClick(){
        submitButtonElement.click();
    }

    public void formWait(){
        wait = baseTest.waitCreate(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("login-form")));
    }

    public void login (String email, String password){
        loginFieldElement.sendKeys(email);
        passwordFieldElement.sendKeys(password);
        submitButtonElement.click();
    }
}
