package org;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HandleCalendar {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.path2usa.com/travel-companions");

        driver.manage().timeouts().implicitlyWait(35,TimeUnit.SECONDS);

        Thread.sleep(4000);

        driver.findElement(By.xpath("//input[@id='travel_date']")).click();

        WebElement month = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']"));

        while (!month.getText().contains("October 2020")) {

            driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();

            System.out.println(month.getText());

        }

        int count = driver.findElements(By.cssSelector("td[class*='day']")).size();

        for (int i = 0; i < count; i++) {
            String text = driver.findElements(By.xpath("//td[@class='day']")).get(i).getText();

            if (text.equalsIgnoreCase("26")) {

                // driver.findElements(By.cssSelector("td[class*='day']")).get(i).click();

                driver.findElements(By.xpath("//td[@class='day']")).get(i).click();

                System.out.println(text);

                break;

            }

        }

    }
}

