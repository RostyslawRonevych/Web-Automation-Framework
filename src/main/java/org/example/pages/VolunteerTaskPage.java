package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VolunteerTaskPage {
    WebDriver driver;
    BaseTest baseTest = new BaseTest();
    WebDriverWait wait;

    @FindBy(id = "name")
    private WebElement nameFieldElement;

    @FindBy(id = "categoryIds")
    private WebElement categoriesElement;
    private Select categoriesDropdown;

    @FindBy(id = "deadline")
    private WebElement deadlineFieldElement;

    @FindBy(id = "description")
    private WebElement descriptionFieldElement;

    @FindBy(id = "expectedOutcome")
    private WebElement expectedOutcomeFieldElement;

    @FindBy(id = "benefit")
    private WebElement benefitFieldElement;

    @FindBy(id = "requirements[0]")
    private WebElement requirements0FieldElement;

    @FindBy(id = "requirements[1]")
    private WebElement requirements1FieldElement;

    @FindBy(id = "interviewRequired")
    private WebElement interviewRequiredCheckboxElement;

    @FindBy(id = "savedMoney")
    private WebElement savingsFieldElement;

    @FindBy(id = "currency")
    private WebElement currencyElement;
    private Select currencyDropdown;

    @FindBy(name = "stages[0].name")
    private WebElement stages0nameFieldElement;

    @FindBy(name = "stages[0].duration")
    private WebElement stages0durationFieldElement;

    @FindBy(name = "stages[0].durationMeasure")
    private WebElement stages0durationMeasureElement;
    private Select stages0durationMeasureDropdown;

    @FindBy(name = "stages[1].description")
    private WebElement stages1descriptionFieldElement;

    @FindBy(name = "stages[1].name")
    private WebElement stages1nameFieldElement;

    @FindBy(name = "stages[1].duration")
    private WebElement stages1durationFieldElement;

    @FindBy(name = "stages[1].durationMeasure")
    private WebElement stages1durationMeasureElement;
    private Select stages1durationMeasureDropdown;

    @FindBy(name = "stages[0].description")
    private WebElement stages0descriptionFieldElement;

    @FindBy(xpath = "//button[@value='PUBLISHED']")
    private WebElement submitPublishButtonElement;

    public VolunteerTaskPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        categoriesDropdown = new Select(categoriesElement);
        currencyDropdown  = new Select(currencyElement);
        stages0durationMeasureDropdown = new Select(stages0durationMeasureElement);
        stages1durationMeasureDropdown = new Select(stages1durationMeasureElement);
    }

    public void setTaskName(String value){
        nameFieldElement.sendKeys(value);
    }

    public void setTaskCategory(int value){
        categoriesDropdown.selectByIndex(value);
    }

    public void setTaskExpDate(String value){
        deadlineFieldElement.sendKeys(value);
    }

    public void setTaskDescription(String value){
        descriptionFieldElement.sendKeys(value);
    }

    public void setTaskOutcome(String value){
        expectedOutcomeFieldElement.sendKeys(value);
    }

    public void setTaskBenefit(String value){
        benefitFieldElement.sendKeys(value);
    }

    public void setTaskSavings(String value){
        savingsFieldElement.sendKeys(value);
    }

    public void setTaskCurrency(int value){
        currencyDropdown.selectByIndex(value);
    }

    public void setTaskRequirements(String value){
        requirements0FieldElement.sendKeys(value);
    }

    public void setTaskInterview(boolean value){
        if(value == true){
            interviewRequiredCheckboxElement.click();
        }
    }

    public void setTaskStage0name(String value){
        stages0nameFieldElement.sendKeys(value);
    }

    public void setTaskStage0Duration(String value){
        stages0durationFieldElement.sendKeys(value);
    }

    public void setTaskStage0Measurement(int value){
        stages0durationMeasureDropdown.selectByIndex(value);
    }

    public void setTaskStage0Description(String value){
        stages0descriptionFieldElement.sendKeys(value);
    }

    public void setTaskStage1name(String value){
        stages1nameFieldElement.sendKeys(value);

    }

    public void setTaskStage1Duration(String value){
        stages1durationFieldElement.sendKeys(value);
    }

    public void setTaskStage1Measurement(int value){
        stages1durationMeasureDropdown.selectByIndex(value);
    }

    public void setTaskStage1Description(String value){
        stages1descriptionFieldElement.sendKeys(value);
    }

    public void submitPublishClick(){
        submitPublishButtonElement.click();
    }
}
