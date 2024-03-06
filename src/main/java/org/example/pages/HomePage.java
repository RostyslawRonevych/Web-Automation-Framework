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

    @FindBy(name = "organizations")
    private WebElement organizationsButton;

    @FindBy(id = "tasksDropdown")
    private WebElement tasksDropdown;

    @FindBy(xpath = "//a[@href='/tasks/register/partner']")
    private WebElement registerPartnerTask;

    @FindBy(xpath = "//a[@href='/tasks/register/volunteer']")
    private WebElement registerVolunteerTask;

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

    public void organizationsButtonClick(){
        organizationsButton.click();
    }

    public void tasksDropdownClick(){
        tasksDropdown.click();
    }

    public void registerPartnerTaskClick(){
        registerPartnerTask.click();
    }

    public void registerVolunteerTaskClick(){
        registerVolunteerTask.click();
    }
}
