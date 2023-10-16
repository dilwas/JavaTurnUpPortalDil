import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

public class Program {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();


        driver.navigate().to("http://horse.industryconnect.io/Account/Login");
        WebElement usernameTextbox = driver.findElement(By.id("UserName"));
        usernameTextbox.sendKeys("hari");

        WebElement passwordTextbox = driver.findElement(By.id("Password"));
        passwordTextbox.sendKeys("123123");



    }
}
