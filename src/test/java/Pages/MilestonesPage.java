package Pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesPage extends BasePage {


    // Блок описания селекторов для элементов

    private By addMilestoneButtonLocator = By.xpath(".//span[text()='Add Milestone']");
    private By nameInputLocator = By.cssSelector("label +#name");
    private By addAndSaveButtonLocator = By.cssSelector("#accept");


    //блок инициализации
    public MilestonesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return addMilestoneButtonLocator;
    }

    // Блок атомарных методов
    public WebElement addMilestoneButton (){return driver.findElement(addMilestoneButtonLocator);}
    public WebElement nameInput () {return driver.findElement(nameInputLocator);}
    public WebElement addAndSaveButton () {return driver.findElement(addAndSaveButtonLocator);}



}
