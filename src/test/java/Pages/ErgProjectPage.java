package Pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErgProjectPage extends BasePage {
    private final static String pagePath = "/index.php?/milestones/overview/55";
    public MilestoneEditPage milestoneEditPage;
    public MilestonesOfErgProjectPage milestonesOfErgProjectPage;

    private By nameOfProjectLocator = By.cssSelector(".content-header-title");
    private By addMilestoneButtonLocator = By.cssSelector("#navigation-milestones-add > span");

    public ErgProjectPage(WebDriver driver) {
        super(driver);
        milestoneEditPage = new MilestoneEditPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return nameOfProjectLocator;
    }

    public WebElement nameOfProject ()
    {return waitsService.waitForExists(nameOfProjectLocator);}

    public WebElement getAddMilestoneButton ()
    {return waitsService.waitForExists(addMilestoneButtonLocator);}

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

}
