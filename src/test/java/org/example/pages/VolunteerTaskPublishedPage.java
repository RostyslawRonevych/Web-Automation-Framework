package org.example.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.Model.VolunteerTask;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.opentest4j.AssertionFailedError;

import java.util.Objects;

public class VolunteerTaskPublishedPage {
    WebDriver driver;
    BaseTest baseTest = new BaseTest();
    WebDriverWait wait;

    private static final Logger logger = LogManager.getLogger(VolunteerTaskPublishedPage.class);

    @FindBy(id = "tasksDropdown")
    private WebElement tasksDropdown;

    @FindBy(xpath = "//a[@href='/tasks/register/volunteer']")
    private WebElement registerVolunteerTask;

    @FindBy(name = "task-name")
    private WebElement taskNameField;

    @FindBy(name = "task-description")
    private WebElement taskDescriptionField;

    @FindBy(name = "expected-outcome")
    private WebElement expectedOutcomeField;

    @FindBy(xpath = "//div[@name='volunteer-requirements']//li")
    private WebElement volunteerRequirementsField;

    @FindBy(name = "categories")
    private WebElement categoriesField;

    @FindBy(name = "task-deadline")
    private WebElement taskDeadlineField;

    @FindBy(xpath = "//div[@name='saved-money']//span")
    private WebElement savedMoneyField;

    public VolunteerTaskPublishedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void verifyTaskData(VolunteerTask task){
        try {
            String taskName = taskNameField.getText();
            Assertions.assertEquals(taskName, task.getTaskName());
            logger.info("Task name was verified successfully");
        } catch (AssertionFailedError e){
            logger.error("Task name is wrong \n" + "Actual task name: " + taskNameField.getText() + "\n" + "Expected task name: " + task.getTaskName());
        }

        try {
            String taskDescription = taskDescriptionField.getText();
            Assertions.assertEquals(taskDescription, task.getTaskDescription());
            logger.info("Task description was verified successfully");
        } catch (AssertionFailedError e){
            logger.error("Task description is wrong \n" + "Actual task description: " + taskDescriptionField.getText() + "\n" + "Expected description name: " + task.getTaskDescription());
        }

        try {
            String taskOutcome = expectedOutcomeField.getText();
            Assertions.assertEquals(taskOutcome, task.getOutputDescription());
            logger.info("Task outcome was verified successfully");
        } catch (AssertionFailedError e){
            logger.error("Task Outcome is wrong \n" + "Actual task Outcome: " + expectedOutcomeField.getText() + "\n" + "Expected task Outcome: " + task.getOutputDescription());
        }

        try {
            String volunteerRequirements = volunteerRequirementsField.getText();
            Assertions.assertEquals(volunteerRequirements, task.getRequirements());
            logger.info("Task volunteer requirements was verified successfully");
        } catch (AssertionFailedError e){
            logger.error("Task volunteerRequirements is wrong \n" + "Actual task volunteerRequirements: " + volunteerRequirementsField.getText() + "\n" + "Expected task volunteerRequirements: " + task.getRequirements());
        }

        try {
            String taskDeadline = taskDeadlineField.getText();
            Assertions.assertEquals(taskDeadline, task.getExpDate());
            logger.info("Task deadline was verified successfully");
        } catch (AssertionFailedError e){
            logger.error("Task Deadline is wrong \n" + "Actual task Deadline: " + taskDeadlineField.getText() + "\n" + "Expected task Deadline: " + task.getExpDate());
        }

        try {
            String savedMoney = savedMoneyField.getText();
            Assertions.assertEquals(savedMoney, task.getMoneySum());
            logger.info("Task saved money was verified successfully");
        } catch (AssertionFailedError e){
            logger.error("Task savedMoney is wrong \n" + "Actual task savedMoney: " + savedMoneyField.getText() + "\n" + "Expected task name: " + task.getMoneySum());
        }
    }

    public void tasksDropdownClick(){
        tasksDropdown.click();
    }

    public void registerVolunteerTaskClick(){
        registerVolunteerTask.click();
    }
}
