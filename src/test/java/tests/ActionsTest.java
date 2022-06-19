package tests;

import BaseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;
import java.util.List;

public class ActionsTest extends BaseTest {
    @Test
    public void hoverTest() {
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        List<WebElement> targetElement = wait.waitForAllVisibleElementsLocatedBy(By.cssSelector(".figure"));// наводим на элемент
        actions.moveToElement(targetElement.get(0), 10, 10) //перемещение курсора по осям x и y,те. дальше от верхнего левого угла
                .click(wait.waitForExists(By.cssSelector("[href='/users/1']")))//кликнуть на появившиеся


                /*.moveToElement(targetElement.get(1))
                .pause(2000)
                .moveToElement(targetElement.get(2))
                .pause(2000)*/
                .build()  //обязательная форма после действий - собирает все действия
                .perform();  // обязательна
    }

    @Test
    public void fileUploadTest() throws InterruptedException { // загрузка файла (добавляем в ресурсы избражение)
        driver.get("http://the-internet.herokuapp.com/upload");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));
        fileUploadPath.sendKeys("C:/Users/teren/IdeaProjects/TAF/target/test-classes/123.png");
        wait.waitForExists(By.id("file-submit")).submit();

        Assert.assertTrue(wait.waitForExists(By.xpath("//*/h3[text()='File Uploaded!']")).isDisplayed());
        WebElement nameOfUploadFile = wait.waitForExists(By.id("uploaded-files"));
        Assert.assertEquals(nameOfUploadFile.getText(), "123.png");

    }

    @Test
    public void contextMenu() {
        driver.get("http://the-internet.herokuapp.com/context_menu");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement box = wait.waitForExists(By.id("hot-spot"));
        actions.moveToElement(box)
                .contextClick()
                .build()
                .perform();

        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "You selected a context menu");
        alert.accept();
    }

    @Test
    public void dynamicControls() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement checkbox = wait.waitForExists(By.cssSelector("[type='checkbox']"));
        WebElement removeButton = wait.waitForExists(By.cssSelector("[onclick='swapCheckbox()']"));

        actions.moveToElement(checkbox)
                .click()
                .moveToElement(removeButton)
                .click()
                .build()
                .perform();
        WebElement itsGoneMessage = wait.waitForExists(By.xpath("//*[@id='message']"));
        Assert.assertEquals(itsGoneMessage.getText(), "It's gone!");
        Assert.assertTrue(wait.waitForElementInvisible(checkbox));

        WebElement input = wait.waitForExists(By.cssSelector("[type='text']"));
        Assert.assertFalse(input.isEnabled());
        WebElement enableButton = wait.waitForExists(By.cssSelector("[onclick='swapInput()']"));
        actions.moveToElement(enableButton, 10, 10)
                .click()
                .build()
                .perform();

        WebElement enabledMessage = wait.waitForExists(By.xpath("//*[@id='message']"));
        Assert.assertEquals(enabledMessage.getText(), "It's enabled!");
        Assert.assertTrue(input.isEnabled());
    }

    @Test
    public void frames() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/frames");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement iFrameLink = wait.waitForExists(By.xpath("//*[@id='content']/div/ul/li[2]/a"));
        actions.moveToElement(iFrameLink)
                .click()
                .build()
                .perform();

        driver.switchTo().frame(wait.waitForExists(By.cssSelector("#mce_0_ifr")));
        WebElement text = wait.waitForExists(By.xpath("//*[@id='tinymce']/p"));
        Assert.assertEquals(text.getText(), "Your content goes here.");
        driver.switchTo().parentFrame();

    }
}




