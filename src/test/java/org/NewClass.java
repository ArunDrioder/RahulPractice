package org;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NewClass
{
    public static WebDriver driver;


    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);

        String[] overallProdNameArray = {"Brocolli","Cauliflower","Potato"};
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        addItemsToCart(driver,overallProdNameArray);

        driver.findElement(By.cssSelector("img[alt ='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        driver.findElement(By.xpath("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
        System.out.println(driver.findElement(By.cssSelector("span.promoinfo")).getText());

        driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();

    }

    private static void addItemsToCart(WebDriver driver, String[] overallProdNameArray) throws InterruptedException {
        int j =0;


        List<WebElement> allProductNames = driver.findElements(By.cssSelector("h4.product-name"));
        for (int i = 0; i<allProductNames.size();i++)
        {
            String[] productNames = allProductNames.get(i).getText().split("-");
            String finalFormattedName = productNames[0].trim();

            //converting the above string[] to Arraylist to check whether the string array contains the name that we get from
            // the productNames list here.

            List productNameArrayList = Arrays.asList(overallProdNameArray);

            if (productNameArrayList.contains(finalFormattedName))
            {
                j++;
                Thread.sleep(1000);
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if (j==overallProdNameArray.length)
                    break;
            }


        }
    }


}
