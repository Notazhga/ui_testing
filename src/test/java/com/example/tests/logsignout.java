package com.example.tests;

import com.example.pages.HomePage;
import com.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

//import org.openqa.selenium.firefox.FirefoxDriver;

public class logsignout {
private WebDriver driver;
private String baseUrl;
private boolean acceptNextAlert = true;
private StringBuffer verificationErrors = new StringBuffer();


        @BeforeClass(alwaysRun = true)
public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "http://redmine-train.dev.thumbtack.net:3000/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

@Test
public void test1LoginSignOut() throws Exception {
        driver.get(baseUrl + "/");

        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickSigninLink();
        homePage = loginPage.login("nkamarskaya", "o3CDWFAN");
        assertTrue(homePage.UserNameDisp()); // проверка входа nkamarskaya
        homePage = homePage.clickSignOut();
        assertTrue(homePage.LogOutDisp()); // проверка выхода из учетки
}
@AfterClass(alwaysRun = true)
public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
        fail(verificationErrorString);
        }
}
}

