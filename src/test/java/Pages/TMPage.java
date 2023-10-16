package Pages;

import Utilities.WaitHelpers;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TMPage
{
    //Test case - Create a new Time record
    public void CreateTimeRecord(WebDriver driver) throws InterruptedException {
        // WebDriverWait webDriverWait = new WebDriverWait(driver, TimeSpan.FromSeconds(10));
        //webDriverWait.Until(SeleniumExtras.WaitHelpers.ExpectedConditions.ElementIsVisible(By.XPath("//*[@id=\"container\"]/p/a")));
        WaitHelpers.WaitToBeClickabel(driver, "Xpath", "//*[@id=\"container\"]/p/a", 5);
        //Click on the create new button
        WebElement createNewButton = driver.findElement(By.xpath("//*[@id=\"container\"]/p/a"));
        createNewButton.click();

        //Select time from dropdown
        WebElement typemainCodeDropdown = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[1]/div/span[1]/span/span[1]"));
        typemainCodeDropdown.click();
        WebElement typeCodeDropdown = driver.findElement(By.xpath("//*[@id=\"TypeCode_listbox\"]/li[2]"));
        typeCodeDropdown.click();

        //Enter code
        WebElement codeTextBox = driver.findElement(By.id("Code"));
        WaitHelpers.WaitToBeClickabel(driver, "Id", "Code", 7);
        codeTextBox.sendKeys("12345");

        //Enter Description
        WaitHelpers.WaitToBeVisible(driver, "Id", "Description", 7);
        WebElement descriptionTextBox = driver.findElement(By.id("Description"));
        descriptionTextBox.sendKeys("This is a test 1");

        //Enter price
        WebElement priceTextBox = driver.findElement(By.xpath("//*[@id=\"TimeMaterialEditForm\"]/div/div[4]/div/span[1]/span/input[1]"));
        priceTextBox.sendKeys("101");

        //Click on the save button
        WebElement saveButton = driver.findElement(By.id("SaveButton"));
        saveButton.click();
        Thread.sleep(5000);
    }

    public void AssertCreateTmRecord(WebDriver driver)
    {
        //Check if a new Time record has been created successfully
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        goToLastPageButton.click();

        WebElement newCode = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        Assert.isTrue(newCode.getText() == "12345", "Time record has not created");
    }


    //Test case - Edit the created new Time record
    public void EditTimeRecord(WebDriver driver) throws InterruptedException {
        //Nabvigaeting to last page
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        goToLastPageButton.click();

        //Click edit button of last record
        WebElement editButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[1]"));
        editButton.click();

        //Change the code
        WebElement editCodeTextBox = driver.findElement(By.id("Code"));
        editCodeTextBox.clear();
        editCodeTextBox.sendKeys("67890");

        //Click on the save button
        WebElement editSaveButton = driver.findElement(By.id("SaveButton"));
        editSaveButton.click();

        Thread.sleep(5000);
    }

    public void AsserteEditTMRecord(WebDriver driver)
    {
        //Check if the Time record has been updated successfully
        WebElement editGoToLastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        editGoToLastPageButton.click();

        WebElement updatedCode = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        Assert.isTrue(updatedCode.getText() == "67890", "Time record has not updated");
    }

    //Test case - Delete the updated Time record
    public void DeleteTimeRecord(WebDriver driver) throws InterruptedException {
        //Nabvigaeting to last page
        WebElement goToLastPageButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[4]/a[4]/span"));
        goToLastPageButton.click();

        //Click delete button of last record
        WebElement deleteButton = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[5]/a[2]"));
        deleteButton.click();

        //Click Ok button on alert popup
        driver.switchTo().alert().accept();

        Thread.sleep(3000);
    }

    public void AsserteDeleteTmRecord(WebDriver driver)
    {
        //Verifying whether last deleted record is removed from the list
        WebElement lastCode = driver.findElement(By.xpath("//*[@id=\"tmsGrid\"]/div[3]/table/tbody/tr[last()]/td[1]"));
        Assert.isTrue(lastCode.getText() != "67890", "Last record has not deleted");
    }
}


