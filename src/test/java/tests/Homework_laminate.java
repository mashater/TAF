package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

            driver.findElement(By.id("ln_room_id")).sendKeys("500");
            driver.findElement(By.id("wd_room_id")).sendKeys("400");

        }
}


