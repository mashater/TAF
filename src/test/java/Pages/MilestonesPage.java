package Pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesPage extends BasePage {
    private final static String pagePath = "/index.php?/milestones/add/3/1";

    // Блок описания селекторов для элементов
    private By nameInputLocator = By.cssSelector("label +#name");
    private By addAndSaveButtonLocator = By.cssSelector("#accept");


    //блок инициализации
    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return nameInputLocator;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов
    public WebElement nameInput () {return driver.findElement(nameInputLocator);}
    public WebElement addAndSaveButton () {return driver.findElement(addAndSaveButtonLocator);}



}
