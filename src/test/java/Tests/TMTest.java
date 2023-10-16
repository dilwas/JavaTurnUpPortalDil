package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TMPage;
import Utilities.CommonDriver;
import Utilities.WaitHelpers;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TMTest extends CommonDriver
{
    @BeforeTest
    public void setup() throws InterruptedException {
        //Open chrome browser
        driver = new ChromeDriver();
        //Loginpage page object initialization and definition
        LoginPage loginPageObj = new LoginPage();
        loginPageObj.LoginActions(driver);

        //Homepage page object initialization and definition
        HomePage homePageObj = new HomePage();
        homePageObj.VerifySucssesLogin(driver);
        homePageObj.GoToTMPage(driver);
    }

    @Test(priority = 0, description = "This test create new time records with valid data")
    public void TestCreateTimeRecord() throws InterruptedException {
        //TMpage page object initialization and definition
        TMPage tmPageObj = new TMPage();
        tmPageObj.CreateTimeRecord(driver);
    }

    @Test(priority = 1, description = "This test update an excisting time record with valid data")
    public void TestEditTimeRecord() throws InterruptedException {
        TMPage tmPageObj = new TMPage();
        tmPageObj.EditTimeRecord(driver);
    }

    @Test(priority = 2, description = "This delets an excisting time record")
    public void TestDeleteTimeRecord() throws InterruptedException {
        TMPage tmPageObj = new TMPage();
        tmPageObj.DeleteTimeRecord(driver);
    }

    @AfterTest
    public void CloseTestRun()
    {
        driver.quit();
    }
}


