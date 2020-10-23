package org;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HTMLTableClass {
    public static void main(String[] args) {
        int sum = 0;

        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.cricbuzz.com/live-cricket-scorecard/29880/north-group-t20-blast-2020");
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        WebElement table = driver.findElement(By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
        int rowCount = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']")).size();
        int count = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).size();

        for (int i = 0; i < count - 2; i++)
        {
            String value = table.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")).get(i).getText();
           int valueToInteger = Integer.parseInt(value);
           sum = sum+valueToInteger;
        }

        String extras = driver.findElement(By.xpath("//div[text() = 'Extras']/following-sibling::div")).getText();
        int extrasToInteger = Integer.parseInt(extras);
        int totalSumValue = sum+extrasToInteger;
        System.out.println(totalSumValue);

        String total = driver.findElement(By.xpath("//div[text() = 'Total']/following-sibling::div")).getText();
        int totalToInteger = Integer.parseInt(total);
        System.out.println(totalToInteger);

        if (totalToInteger==totalSumValue)
            System.out.println("It's Equal");
        else
            System.out.println("Not Equal");

    }
}







