package tests;

import BaseEntities.BaseTest;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JSTest extends BaseTest {

    @Test
    public void clickJSTest() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/jqueryui/menu#");

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement webElement = driver.findElement(By.id("ui-id-2"));
        jsExecutor.executeScript("arguments[0].click();", webElement); // замена первого аргумента на вебэлемент

        Thread.sleep(5000);
    }

    @Test
    public void actionTest1() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");

        WebElement source = driver.findElement(By.id("column-a"));
        WebElement target = driver.findElement(By.id("column-b"));

        Thread.sleep(3000);

        DragAndDropJS(source, target, driver);

        Thread.sleep(3000);
    }


    public void DragAndDropJS(WebElement source, WebElement destination, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {\n"
                + "var event =document.createEvent(\"CustomEvent\");\n"
                + "event.initCustomEvent(typeOfEvent,true, true, null);\n"
                + "event.dataTransfer = {\n" + "data: {},\n" + "setData: function (key, value) {\n" + "this.data[key] = value;\n"
                + "},\n" + "getData: function (key) {\n"
                + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n" + "}\n" + "\n"
                + "function dispatchEvent(element, event,transferData) {\n" + "if (transferData !== undefined) {\n"
                + "event.dataTransfer = transferData;\n" + "}\n" + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n" + "}\n" + "\n"
                + "function simulateHTML5DragAndDrop(element, destination) {\n" + "var dragStartEvent =createEvent('dragstart');\n"
                + "dispatchEvent(element, dragStartEvent);\n" + "var dropEvent = createEvent('drop');\n"
                + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                + "var dragEndEvent = createEvent('dragend');\n"
                + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                + "simulateHTML5DragAndDrop(source,destination);", source, destination);
    }

    @Test
    public void HWJSTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_content?with_content=static");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement link = driver.findElement(By.linkText("click here"));
        js.executeScript("arguments[0].click();", link);

        js.executeScript("history.go(0)");

        String s = "https://the-internet.herokuapp.com/javascript_alerts";
        js.executeScript("window.location = \'"+s+"\'");


        js.executeScript("alert('NEW ALERT');");
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "NEW ALERT");
        alert.accept();

    }
}
