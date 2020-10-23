package org;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NewAutoDropDown
{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
        driver.get("https://www.makemytrip.com");
//        driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
//        WebElement fromCity = driver.findElement(By.id("fromCity"));
//        fromCity.click();
//        fromCity.sendKeys("mum");
//        Thread.sleep(2000);
//        fromCity.sendKeys(Keys.ENTER);

        WebElement popUp = driver.findElement(By.cssSelector(".makeFlex.hrtlCenter.font10.makeRelative.lhUser"));

        int popSize = driver.findElements(By.cssSelector(".makeFlex.hrtlCenter.font10.makeRelative.lhUser")).size();

        if(popSize > 0){

            popUp.click();

        }

        driver.findElement(By.id("fromCity")).click();

        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);

        WebElement source = driver.findElement(By.xpath("//input[@placeholder='From']"));

        source.sendKeys("MUM");

        Thread.sleep(2000);

        source.sendKeys(Keys.ARROW_DOWN);

        source.sendKeys(Keys.ENTER);

// Enter text Bangalore to destination search

        WebElement destination = driver.findElement(By.xpath("//input[@placeholder='To']"));

        destination.sendKeys("Bengaluru");

        Thread.sleep(2000);

        destination.sendKeys(Keys.ARROW_DOWN);

        destination.sendKeys(Keys.ENTER);

        Thread.sleep(2000);





    }
}
