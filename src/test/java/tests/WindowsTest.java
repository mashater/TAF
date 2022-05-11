package tests;

import BaseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowsTest extends BaseTest {

    @Test
    public void newTabTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/windows");

        String originalWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();


        Set<String> windowHandlesSet = driver.getWindowHandles();
        List<String> windowHandleList = new ArrayList<>(windowHandlesSet); // множество setов

        driver.switchTo().window(windowHandleList.get(1)); // переключение на второе окно

        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "New Window");

        driver.close(); // закрывает текущую вкладку ( quite - полностью выходит)

        driver.switchTo().window(originalWindow);

        Assert.assertTrue(driver.findElement(By.linkText("Click Here")).isDisplayed());

        WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW); //открываем новое окно
        newWindow.quit(); //закрыть полностью

    }
    @Test
    public void newTabTest1() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/windows");

        String originalWindow = driver.getWindowHandle();
        driver.findElement(By.linkText("Click Here")).click();


        Set<String> windowHandlesSet = driver.getWindowHandles(); // 2 вкладки

        for (String handle : windowHandlesSet) {
            if (!originalWindow.equals(handle)){ // не совпадает
                driver.switchTo().window(handle);
                break;
            }
        }

    }
}
