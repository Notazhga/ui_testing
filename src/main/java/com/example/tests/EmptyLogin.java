package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EmptyLogin {
private WebDriver driver;
private String baseUrl;
private boolean acceptNextAlert = true;
private StringBuffer verificationErrors = new StringBuffer();

@BeforeClass(alwaysRun = true)
public void setUp() throws Exception {
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        baseUrl = "http://redmine-train.dev.thumbtack.net:3000/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

@Test
public void test2EmptyLogin() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.cssSelector("a.login")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("o3CDWFAN");
        driver.findElement(By.name("login")).click();
        assertTrue(isElementPresent(By.cssSelector("div.flash.error")));
        assertTrue(isElementPresent(By.cssSelector("a.login")));
        }

@AfterClass(alwaysRun = true)
public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
        fail(verificationErrorString);
        }
        }

private boolean isElementPresent(By by) {
        try {
        driver.findElement(by);
        return true;
        } catch (NoSuchElementException e) {
        return false;
        }
        }

private boolean isAlertPresent() {
        try {
        driver.switchTo().alert();
        return true;
        } catch (NoAlertPresentException e) {
        return false;
        }
        }

private String closeAlertAndGetItsText() {
        try {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        if (acceptNextAlert) {
        alert.accept();
        } else {
        alert.dismiss();
        }
        return alertText;
        } finally {
        acceptNextAlert = true;
        }
        }
        }
