package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

public class Homework_laminate {
    private WebDriver driver;

        @BeforeMethod
        public void setUp() {
            BrowsersService browsersService = new BrowsersService();
            driver = browsersService.getDriver();
        }
        @AfterMethod
        public void tearDown() {
            driver.quit();}

        @Test
        public void kermifko () throws InterruptedException {
            driver.get("https://calc.by/building-calculators/laminate.html");

            WebElement selectWebElement = driver.findElement(By.id("laying_method_laminate"));
            Select selectMethod = new Select(selectWebElement);
            selectMethod.selectByIndex(2);
            Thread.sleep(2000);

            WebElement lengthRoom = driver.findElement(By.id("ln_room_id"));
            lengthRoom.click();
            lengthRoom.clear();
            lengthRoom.sendKeys("500");

            WebElement widthRoom = driver.findElement(By.id("wd_room_id"));
            widthRoom.click();
            widthRoom.clear();
            widthRoom.sendKeys("400");

            WebElement lengthLaminate = driver.findElement(By.id("ln_lam_id"));
            lengthLaminate.click();
            lengthLaminate.clear();
            lengthLaminate.sendKeys("2000");

            WebElement widthLaminate = driver.findElement(By.id("wd_lam_id"));
            widthLaminate.click();
            widthLaminate.clear();
            widthLaminate.sendKeys("200");
            Thread.sleep(2000);

            driver.findElement(By.id("direction-laminate-id1")).click();
            driver.findElement(By.cssSelector("div.calc-btn-div>a.calc-btn")).click();
            Thread.sleep(2000);

            WebElement amountLaminate = driver.findElement(By.cssSelector("div.calc-footer>div>div>span[style = 'padding:5px 0;font-size:22px; color:#C80303; font-weight:bold;']"));
            Assert.assertEquals(amountLaminate.getText(), "53");

            WebElement amountPackages = driver.findElement(By.cssSelector("div.calc-footer>div>div>span[style = 'padding:5px 0;font-size:18px; color:#0E8C19; font-weight:bold;']"));
            Assert.assertEquals(amountPackages.getText(), "7");

            Thread.sleep(2000);


        }
}


