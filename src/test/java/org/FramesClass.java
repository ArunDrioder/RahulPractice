package org;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class FramesClass
{
    public static void main(String[] args)
    {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://the-internet.herokuapp.com/nested_frames");
        driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
       driver.switchTo().frame("frame-top");

       driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());


    }
}
