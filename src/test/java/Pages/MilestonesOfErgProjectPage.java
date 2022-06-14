package Pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesOfErgProjectPage extends BasePage {
    public MilestoneEditPage milestoneEditPage;
    public MilestonePage milestonePage;
    private final static String pagePath = "/index.php?/milestones/overview/55";
    public By addMilestoneButtonLocator = By.xpath("//span[contains (text(), 'Add Milestone')]");
    public By nameOfFirstMilestoneLocator = By.xpath("//a[text()='First']");
    public By nameOfSecondMilestoneLocator = By.xpath("//a[text()='Second']");
    public By successMassageLocator = By.className("message-success");
    public By deleteButtonLocator = By.className("icon-small-delete");
    public By confirmationDeleteButtonLocator = By.xpath("//*[@id='deleteDialog']/div[3]/a[1]");


    public MilestonesOfErgProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return addMilestoneButtonLocator;
    }
    // Блок атомарных методов
    public WebElement getAddMilestoneButton() {return driver.findElement(addMilestoneButtonLocator);}
    public WebElement getNameOfSecondMilestone() {return driver.findElement(nameOfSecondMilestoneLocator);}
    public WebElement getNameOfFirstMilestone() {return driver.findElement(nameOfFirstMilestoneLocator);}
    public WebElement getSuccessMassage() {return driver.findElement(successMassageLocator);}
    public WebElement getDeleteButton() {return driver.findElement(deleteButtonLocator);}
    public WebElement getConfirmationDeleteButton() {return driver.findElement(confirmationDeleteButtonLocator);}


    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }


}
