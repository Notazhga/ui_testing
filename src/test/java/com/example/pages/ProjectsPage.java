package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProjectsPage {
    private final WebDriver driver;

    @FindBy(linkText = "High School: Test Automation")
    private WebElement TestProjectLink;

    @FindBy(linkText = "New issue")
    private WebElement NewIssueLink;

    public ProjectsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Create_Page clickNewIssue() {
        NewIssueLink.click();
        return new Create_Page(driver);
    }

    public ProjectsPage clickTestProjectLink() {
        TestProjectLink.click();
        return new ProjectsPage(driver);
    }

}
