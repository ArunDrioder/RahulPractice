package org;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HandlingMulitpleWindowsAssignmentClass
{
    public static void main(String[] args)
    {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement multipleWindowClick = driver.findElement(By.linkText("Multiple Windows"));
        multipleWindowClick.click();


        WebElement clickToOpenLink = driver.findElement(By.linkText("Click Here"));
        clickToOpenLink.click();

        Set<String> getWindowHandles = driver.getWindowHandles();
        Iterator<String> windowHandleIterator = getWindowHandles.iterator();
        String parentWindowId = windowHandleIterator.next();
        String childWindowId = windowHandleIterator.next();
        driver.switchTo().window(childWindowId);
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);

        System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());

        driver.switchTo().window(parentWindowId);

        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);

        System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());






    }
}
