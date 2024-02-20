package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(className = "ml-auto")
    private WebElement navRegButton;

    @FindBy(name = "partners")
    private WebElement partnerButton;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navRegButtonClick(){
        navRegButton.click();
    }

    public void partnerButtonClick(){
        partnerButton.click();
    }
}
