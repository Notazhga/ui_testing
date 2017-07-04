package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import com.example.pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class updateAbug {
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
    public void test5UpdateABug() throws Exception {
        driver.get(baseUrl + "/");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickSigninLink();
        homePage = loginPage.login("nkamarskaya", "o3CDWFAN");
        assertTrue(homePage.UserNameDisp()); // проверка входа nkamarskaya
        ProjectsPage projectsPage = homePage.clickProjects();
        projectsPage = projectsPage.clickTestProjectLink();
        Create_Page create_Page = projectsPage.clickNewIssue();
        EditPage editPage =  create_Page.createIssue("1 2 3", "nkamarskaya_bug", "Bug", "//label[16]/input", "Natalia Kamarskaya");
        assertTrue(editPage.IssueCreated());
        assertTrue(editPage.CreatesAuthor());
        assertEquals(editPage.getDescription(), "1 2 3");
        assertEquals(editPage.getSubject(), "nkamarskaya_bug");
        //изменить тикет
        create_Page.clickUpdateButton();
        create_Page.UpdateIssue("50 %","Urgent","Testing"); // вносим изменения
        assertTrue(create_Page.successfulUpdate());
        //проверки изменения
        assertEquals(editPage.CheckPourcents(),"50%");
        assertEquals(editPage.urgentPriority(), "Urgent");
        // выход + проверка
        homePage = homePage.clickSignOut();
        assertTrue(homePage.LogOutDisp());

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
