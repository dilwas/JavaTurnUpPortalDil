package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage
{
    public void LoginActions(WebDriver driver)
    {
        driver.manage().window().maximize();

        //Launch turnup portal and navigate to website login page
        driver.navigate().to("http://horse.industryconnect.io/Account/Login");

        //Identify username textbox and enter valide username
        WebElement usernameTextbox = driver.findElement(By.id("UserName"));
        usernameTextbox.sendKeys("hari");

        //Identify password textbox and enter valide password
        WebElement passwordTextbox = driver.findElement(By.id("Password"));
        passwordTextbox.sendKeys("123123");

        //Identify the login button and click on the button
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/div[3]/input[1]"));
        loginButton.click();
    }

}
