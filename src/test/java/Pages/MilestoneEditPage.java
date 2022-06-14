package Pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestoneEditPage extends BasePage {
    private final static String pagePath = "/index.php?/milestones/overview/3";

    // Блок описания селекторов для элементов
    private By nameInputLocator = By.cssSelector("label +#name");
    private By addAndSaveButtonLocator = By.cssSelector("#accept");


    //блок инициализации
    public MilestoneEditPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return nameInputLocator;
    }



    // Блок атомарных методов
    public WebElement getNameInput() {return driver.findElement(nameInputLocator);}
    public WebElement getAddAndSaveButton() {return driver.findElement(addAndSaveButtonLocator);}


    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }



}
