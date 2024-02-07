package org.example.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MailPage {
    WebDriver driver;
    WebElement targetMailElement;
    @FindBy(xpath = "//a[contains(text(), 'token')]")
    WebElement confirmationLink;
    @FindBy (css = "div.alert-success")
    WebElement confirmationMessage;

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


}
