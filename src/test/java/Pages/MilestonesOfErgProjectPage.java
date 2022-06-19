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
    public WebElement getAddMilestoneButton() {return waitsService.waitForExists(addMilestoneButtonLocator);}
    public WebElement getNameOfSecondMilestone() {return waitsService.waitForExists(nameOfSecondMilestoneLocator);}
    public WebElement getNameOfFirstMilestone() {return waitsService.waitForExists(nameOfFirstMilestoneLocator);}
    public WebElement getSuccessMassage() {return waitsService.waitForExists(successMassageLocator);}
    public WebElement getDeleteButton() {return waitsService.waitForExists(deleteButtonLocator);}
    public WebElement getConfirmationDeleteButton() {return waitsService.waitForExists(confirmationDeleteButtonLocator);}


    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }


}
