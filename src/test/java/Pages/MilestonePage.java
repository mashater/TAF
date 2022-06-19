package Pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonePage extends BasePage {

    // Блок описания селекторов для элементов
    private By nameElementLocator = By.xpath("//*[@id='content-header']/div/div[4]");
    private By editButtonLocator = By.cssSelector(".button-edit");


    //блок инициализации
    public MilestonePage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return nameElementLocator;
    }



    // Блок атомарных методов
    public WebElement getNameElement() {return waitsService.waitForExists(nameElementLocator);}
    public WebElement getEditButton() {return waitsService.waitForExists(editButtonLocator);}

}
