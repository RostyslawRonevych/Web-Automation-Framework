package org.example.pages;

import org.junit.jupiter.api.Assertions;
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

    public void verifySuccessMessage(){
        Assertions.assertTrue(confirmationMessage.getText().contains("Email"));
    }

    public WebDriverWait emailWait(String email){
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(text(), '"+email+"')]")));
        return wait;
    }

    public WebDriverWait successWait(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.alert-success")));
        return wait;
    }


}
