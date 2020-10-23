package org;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorClass
{
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.ksrtc.in");
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        WebElement fromPlaceName = driver.findElement(By.id("fromPlaceName"));
        fromPlaceName.sendKeys("Beng");
        Thread.sleep(3000);
        fromPlaceName.sendKeys(Keys.DOWN);
        fromPlaceName.sendKeys(Keys.DOWN);
        String enteredText = fromPlaceName.getText();
        System.out.println(enteredText);

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String scriptStringToExecute = " return document.getElementById(\"fromPlaceName\").value;";
        String catchedStringValue = (String)jse.executeScript(scriptStringToExecute);
        System.out.println(catchedStringValue);

    }
}
