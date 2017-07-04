package com.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
    private final WebDriver driver;

    @FindBy(name = "username")
    private WebElement LoginBox;

    @FindBy(name = "password")
    private WebElement PasswordBox;

    @FindBy(name = "login")
    private WebElement LoginButton;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        if (!LoginBox.isDisplayed()) {
            throw new IllegalStateException("This is not a Login Page!");
        }
    }

    public HomePage login(String username, String password) {
        LoginBox.sendKeys(username);
        PasswordBox.sendKeys(password);
        LoginButton.submit();
        return new HomePage(driver);
    }

}



