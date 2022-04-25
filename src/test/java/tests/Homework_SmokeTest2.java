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

public class Homework_SmokeTest2 {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        BrowsersService browsersService = new BrowsersService();
        driver = browsersService.getDriver();
    }

    @Test
    public void validateSKF() throws InterruptedException {
        driver.get("http://13gp.by/informatsiya/meditsinskie-kalkulyatory/995-raschet-skorosti-klubochkovoj-filtratsii-skf");
        WebElement selectWebElement = driver.findElement(By.id("oSex"));
        Select selectSex = new Select(selectWebElement);
        selectSex.selectByIndex(1);
        Thread.sleep(2000);

        WebElement kreatinin = driver.findElement(By.id("oCr"));
        WebElement age = driver.findElement(By.id("oAge"));
        WebElement weight = driver.findElement(By.id("oWeight"));
        WebElement height = driver.findElement(By.id("oHeight"));
        WebElement button = driver.findElement(By.cssSelector("input[type='button'][value='Рассчитать']"));


        kreatinin.sendKeys("80");
        age.sendKeys("38");
        weight.sendKeys("55");
        height.sendKeys("163");
        Thread.sleep(2000);
        button.click();

        WebElement resultMDRD = driver.findElement(By.id("txtMDRD"));
        Assert.assertEquals(resultMDRD.getText(), "MDRD: 74 (мл/мин/1,73кв.м)");

        WebElement resultHBP = driver.findElement(By.id("txtMDRD1"));
        Assert.assertEquals(resultHBP.getText(), "ХБП: 2 стадия (при наличии почечного повреждения)");

        WebElement resultCG = driver.findElement(By.id("txtCG"));
        Assert.assertEquals(resultCG.getText(), "Cockroft-Gault: 70 (мл/мин)");

        WebElement resultBSA = driver.findElement(By.id("txtBSA"));
        Assert.assertEquals(resultBSA.getText(), "Поверхность тела:1.58 (кв.м)");
        Thread.sleep(2000);}


    @AfterMethod
    public void tearDown() {
        driver.quit();}

}