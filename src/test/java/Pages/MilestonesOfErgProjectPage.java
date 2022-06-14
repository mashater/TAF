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
    public By successMassageLocator = By.className("message-success");


    public MilestonesOfErgProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return addMilestoneButtonLocator;
    }
    // Блок атомарных методов
    public WebElement getAddMilestoneButton() {return driver.findElement(addMilestoneButtonLocator);}
    public WebElement getNameOfMilestone() {return driver.findElement(nameOfFirstMilestoneLocator);}
    public WebElement getSuccessMassage() {return driver.findElement(successMassageLocator);}


    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }


}
