package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditPage {
    private final WebDriver driver;


    @FindBy(css = "div.flash")
    private WebElement flashMessage;

    @FindBy (css = "p.author")
    private WebElement authorCreated;

    @FindBy(css = "p.pourcent")
    private WebElement flashPourcent;

    @FindBy(id = "issue_priority_id")
    private WebElement priority;

    @FindBy(id = "issue_done_ratio")
    private WebElement doneRatio;

    @FindBy(id = "time_entry_activity_id")
    private WebElement activity;

    @FindBy(name = "commit")
    private WebElement commitButton;

    @FindBy(id = "issue_description")
    private WebElement issueDescription;

    @FindBy(id = "issue_subject")
    private WebElement issueSubject;

    @FindBy (css = "div.wiki > p")
    private WebElement description;

    @FindBy (css = "div.subject > div > h3")
    private WebElement subject;

    @FindBy (css = "td.priority")
    private WebElement checkPriority;

    public EditPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean IssueCreated() {
        return flashMessage.getText().contains("created");
    }

    public Boolean CreatesAuthor() {
        return authorCreated.getText().contains("Added by Natalia Kamarskaya");
    }

    public String CheckPourcents() {
        return flashPourcent.getText(); //* 50 %
    }

    public Boolean IssuePriority() {
        return priority.getText().contains("Urgent");
    }

    public Boolean IssueRatio() {
        return doneRatio.getText().contains("50%");
    }

    public String IssueActivity() {
        return activity.getText();
    }

    public String getDescription() {
        return description.getText();
    }

    public String getSubject() {
        return subject.getText();
    }

    public String urgentPriority() {
        return checkPriority.getText();
    }
}