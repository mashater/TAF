package wrappers;

import org.checkerframework.checker.guieffect.qual.UI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button {
    private UIElement uiElement;

    public Button(WebDriver driver, By by){
        this.uiElement = new UIElement(driver, by);
    }

    public void click(){
        uiElement.click();
    }
    public void submit() {
        uiElement.submit();
    }

    public String getText() {
        return uiElement.getText();
    }

}
