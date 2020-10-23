package org;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HandleMultipleWindowsClass
{
    public static void main(String[] args)
    {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("Enter Your URL Here");
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        Set<String> windowIds = driver.getWindowHandles();
        Iterator<String> windowIdIterator = windowIds.iterator();
        String parentWindowId = windowIdIterator.next();
        String childWindowId = windowIdIterator.next();
        driver.switchTo().window(childWindowId);
        System.out.println(driver.getTitle());//--> This time it should print the new child window's ID.

        driver.switchTo().window(parentWindowId);
        System.out.println(driver.getTitle());//-->This time it should print the parent window's ID.

    }
}
