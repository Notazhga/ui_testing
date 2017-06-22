package com.example.firefox;


import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.openqa.selenium.WebDriver;
import org.junit.*;
//import static org.junit.Assert.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
//import org.testng.*;



public class edit_firefox {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://redmine-train.dev.thumbtack.net:3000/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test5UpdateABug() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.cssSelector("a.login")).click();
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys ("nkamarskaya");
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
        assertTrue(isElementPresent(By.cssSelector("p.author")));
        driver.findElement(By.linkText("Update")).click();
        new Select(driver.findElement(By.id("issue_priority_id"))).selectByVisibleText("Urgent");
        new Select(driver.findElement(By.id("time_entry_activity_id"))).selectByVisibleText("Testing");
        driver.findElement(By.cssSelector("#issue-form > input[name=\"commit\"]")).click();
        assertTrue(isElementPresent(By.cssSelector("h4")));
        driver.findElement(By.cssSelector("a.logout")).click();
        assertTrue(isElementPresent(By.cssSelector("a.login")));
    }

    @After
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
