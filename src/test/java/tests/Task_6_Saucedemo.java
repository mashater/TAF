import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BrowsersService;

import static org.openqa.selenium.By.cssSelector;

public class Task_6_Saucedemo {
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
    public void saucedemo () throws InterruptedException {
        driver.get("https://www.saucedemo.com");


        driver.findElement(By.id("user-name")).sendKeys("standard_user"); //id
        driver.findElement(By.name("password")).sendKeys("secret_sauce");  //name
        driver.findElement(cssSelector("#login-button")).click();//#id
        Thread.sleep(4000);


        driver.findElement(cssSelector("#add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click(); //поиск по атрибуту
        Thread.sleep(2000);

        // поиск по .class
        Assert.assertEquals(driver.findElement(cssSelector(".inventory_item_name")).getText(), "Sauce Labs Bike Light", "Wrong item name");
        Assert.assertEquals(driver.findElement(cssSelector(".inventory_item_price")).getText(), "$9.99", "Wrong item price");
        driver.findElement(cssSelector(".btn.btn_secondary.back.btn_medium")).click(); //.class.class....

        Thread.sleep(4000);

        //остальные поиски локаторов
        Assert.assertTrue(driver.findElement(By.className("app_logo")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.tagName("select")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("Sauce Labs Backpack")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.partialLinkText(" Backpack")).isDisplayed());

        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'style with unequaled laptop and tablet protection.')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'inventory_container')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Add to cart']//ancestor::div[@class=\"pricebar\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//select/descendant::option")).isDisplayed());
        //AND
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='inventory_item_name'] | //div[@class='inventory_item_price']")).isDisplayed());


        Assert.assertTrue(driver.findElement(By.cssSelector("select")).isDisplayed()); //tagname
        Assert.assertTrue(driver.findElement(By.cssSelector("select.product_sort_container")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("select.product_sort_container")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[class='peek']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[alt~='Backpack']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("[class|='title']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class^=inventory]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class$=container]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class*='inve']")).isDisplayed());

    }
    @Test
    public void relativeLocators() throws InterruptedException {
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); //id
        driver.findElement(By.name("password")).sendKeys("secret_sauce");  //name
        driver.findElement(cssSelector("#login-button")).click();//#id

        WebElement element = driver.findElement(RelativeLocator.with(By.cssSelector(".inventory_item_name")).below(By.id("item_4_title_link")).toLeftOf(By.id("item_5_title_link")));
        Assert.assertEquals(element.getText(), "Sauce Labs Bolt T-Shirt");


}}
