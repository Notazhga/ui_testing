package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateABug {
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
public void test4CreateABug() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.cssSelector("a.login")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("nkamarskaya");
        driver.findElement(By.id("password")).clear();
        driver.findElement(By.id("password")).sendKeys("o3CDWFAN");
        driver.findElement(By.name("login")).click();
        assertTrue(isElementPresent(By.linkText("nkamarskaya")));
        driver.findElement(By.linkText("Projects")).click();
        driver.findElement(By.linkText("High School: Test Automation")).click();
        driver.findElement(By.linkText("New issue")).click();
        new Select(driver.findElement(By.id("issue_tracker_id"))).selectByVisibleText("Bug");
        driver.findElement(By.id("issue_subject")).clear();
        driver.findElement(By.id("issue_subject")).sendKeys("nkamarskaya_bug");
        driver.findElement(By.id("issue_description")).clear();
        driver.findElement(By.id("issue_description")).sendKeys("1 2 3");
        new Select(driver.findElement(By.id("issue_assigned_to_id"))).selectByVisibleText("Natalia Kamarskaya");
        driver.findElement(By.xpath("(//input[@id='issue_watcher_user_ids_'])[15]")).click();
        driver.findElement(By.name("commit")).click();
        assertTrue(isElementPresent(By.cssSelector("div.flash.notice")));
        assertEquals(driver.findElement(By.cssSelector("div.wiki > p")).getText(), "1 2 3");
        assertEquals(driver.findElement(By.cssSelector("div.subject > div > h3")).getText(), "nkamarskaya_bug");
        driver.findElement(By.cssSelector("a.logout")).click();
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
