package org;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitAssignmentClass
{
    public static void main(String[] args)
    {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.itgeared.com/demo/1506-ajax-loading.html");
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);//--> This is to wait until the element to be clicked is loaded.
        driver.findElement(By.xpath("//a[contains(text(),'Click to load get data via Ajax!')]")).click();

        WebDriverWait wait = new WebDriverWait(driver,8);
        WebElement elementToBePrinted = driver.findElement(By.xpath("//div[@id='results']"));
        wait.until(ExpectedConditions.visibilityOf(elementToBePrinted));//--> Here in this place, I have passed the element variable directly,
        // since I have located the element separately in the previous step. Do let me know if it's wrong.
        System.out.println(elementToBePrinted.getText());


    }
}
