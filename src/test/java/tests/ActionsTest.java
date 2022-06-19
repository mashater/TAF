package tests;

import BaseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;
import java.util.List;

public class ActionsTest extends BaseTest {
    @Test
    public void hoverTest () {
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        List<WebElement> targetElement = wait.waitForAllVisibleElementsLocatedBy(By.cssSelector(".figure"));// наводим на элемент
        actions.moveToElement(targetElement.get(0), 10, 10) //перемещение курсора по осям x и y,те. дальше от верхнего левого угла
                .click(wait.waitForExists(By.cssSelector("[href='/users/1']")))//кликнуть на появившиеся


                .moveToElement(targetElement.get(1))
                .pause(2000)
                .moveToElement(targetElement.get(2))
                .pause(2000)
                .build()  //обязательная форма после действий - собирает все действия
                .perform();  // обязательна
    }
    @Test
    public void fileUploadTest() throws InterruptedException { // загрузка файла (добавляем в ресурсы избражение)
        driver.get("http://the-internet.herokuapp.com/upload");

        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(10));

        WebElement fileUploadPath = wait.waitForExists(By.id("file-upload"));
        String pathToFile = ActionsTest.class.getClassLoader().getResource("download.jpeg").getPath(); // изображение добавляем в ресурсы и меняем имя тут
        System.out.println(pathToFile);
        fileUploadPath.sendKeys(pathToFile);
        wait.waitForExists(By.id("file-submit")).submit();

        Thread.sleep(5000);
    }

}




