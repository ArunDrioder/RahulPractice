package org;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TablePractice
{
    public static void main(String[] args) {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement tableElement = driver.findElement(By.id("product"));
        System.out.println("The total rows are :" + tableElement.findElements(By.tagName("tr")).size());
        System.out.println(tableElement.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());



        List<WebElement> secondrow=tableElement.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));



        System.out.println(secondrow.get(0).getText());



        System.out.println(secondrow.get(1).getText());



        System.out.println(secondrow.get(2).getText());

    }
}
