package Pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage
{
    public void VerifySucssesLogin(WebDriver driver) throws InterruptedException {
        //Check if user has logged in successfully
        WebElement helloHari = driver.findElement(By.xpath("//*[@id=\"logoutForm\"]/ul/li/a"));
        Thread.sleep(2000);
        System.out.println(helloHari.getText());
        if (helloHari.getText().equals("Hello hari!"))
        {
            System.out.println("User has loged in successefully");
        }
        else
        {
            System.out.println("User has not loged in");
        }
    }
    public void GoToTMPage(WebDriver driver) throws InterruptedException {
        try
        {
            //Navigate to Time & Material module
            WebElement administrationDropdown = driver.findElement(By.xpath("/html/body/div[3]/div/div/ul/li[5]/a"));
            administrationDropdown.click();
        }
        catch(Exception exception)
        {
            Assert.isTrue(1==0,"Turnup portal not displayed", exception.getMessage());
        }

        WebElement tmOption = driver.findElement(By.xpath("//a[contains(text(),'Time & Materials')]"));
        tmOption.click();
        Thread.sleep(3000);



    }

}
