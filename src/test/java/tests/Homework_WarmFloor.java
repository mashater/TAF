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

public class Homework_WarmFloor {
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
        driver.get("https://kermi-fko.ru/raschety/Calc-Rehau-Solelec.aspx");

        driver.findElement(By.id("el_f_width")).sendKeys("2");
        driver.findElement(By.id("el_f_lenght")).sendKeys("3");

        WebElement selectWebElement = driver.findElement(By.id("room_type"));
        Select selectRoom = new Select(selectWebElement);
        selectRoom.selectByIndex(1);
        Thread.sleep(2000);

        WebElement selectWebElement1 = driver.findElement(By.id("heating_type"));
        Select selectType = new Select(selectWebElement1);
        selectType.selectByIndex(2);

        driver.findElement(By.id("el_f_losses")).sendKeys("2000");
        driver.findElement(By.cssSelector(".buttHFcalc")).click();
        Thread.sleep(2000);

        WebElement result1 = driver.findElement(By.id("floor_cable_power"));
        result1.click();
        Assert.assertEquals(result1.getAttribute("value"), "1113");

        WebElement result2 = driver.findElement(By.id("spec_floor_cable_power"));
        result1.click();
        Assert.assertEquals(result2.getAttribute("value"), "186");

    }
}
