package org;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class PracticalAssignment
{
    public static void main(String[] args)
    {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);

//        driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
//
//        String opt=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
        WebElement chosenCheckBox = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input"));
        chosenCheckBox.click();
        String choesenCheckBoxText = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
        System.out.println(choesenCheckBoxText);

        WebElement selectElement = driver.findElement(By.id("dropdown-class-example"));
        Select select = new Select(selectElement);
        select.selectByVisibleText(choesenCheckBoxText);

        WebElement enterName = driver.findElement(By.name("enter-name"));
        enterName.sendKeys(choesenCheckBoxText);

        WebElement alertBtn = driver.findElement(By.id("alertbtn"));
        alertBtn.click();

        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        String alertMessageText = driver.switchTo().alert().getText();

        if (alertMessageText.contains(choesenCheckBoxText))
        {
            System.out.println("Yes,the alert message contains the option label that we've chosen from the checkbox");
        }
        else
        {
            System.out.println("Sorry, the option label is not found");
        }
    }
}
