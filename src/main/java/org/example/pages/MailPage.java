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

public class MailPage {
    WebDriver driver;
    WebElement targetMailElement;
    WebDriverWait wait;
    BaseTest baseTest = new BaseTest();
    @FindBy(xpath = "//a[contains(text(), 'token')]")
    private WebElement confirmationLink;
    @FindBy (css = "div.alert-success")
    private WebElement confirmationMessage;

    public MailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void targetMailClick (String email){
        targetMailElement = driver.findElement(By.xpath("//div[contains(text(), '"+email+"')]"));
        targetMailElement.click();
    }

    public void confirmationLinkClick(){
        confirmationLink.click();
    }

    public String getSuccessMessage(){
        String message;
        message = confirmationMessage.getText();
        return message;
    }

    public void emailWait(String email){
        wait = baseTest.waitCreate(driver, 100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), '"+email+"')]")));
    }

    public void successWait(){
        wait = baseTest.waitCreate(driver, 100);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.alert-success")));
    }


}
