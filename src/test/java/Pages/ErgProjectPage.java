package Pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErgProjectPage extends BasePage {
    private final static String pagePath = "/index.php?/projects/overview/3";
    public MilestoneEditPage milestoneEditPage;
    public MilestonesOfErgProjectPage milestonesOfErgProjectPage;

    private By nameOfProjectLocator = By.cssSelector(".content-header-title");
    private By addMilestoneButtonLocator = By.cssSelector("#sidebar #sidebar-milestones-add");

    public ErgProjectPage(WebDriver driver) {
        super(driver);
        milestoneEditPage = new MilestoneEditPage(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return nameOfProjectLocator;
    }

    public WebElement nameOfProject ()
    {return driver.findElement(nameOfProjectLocator);}

    public WebElement getAddMilestoneButton ()
    {return driver.findElement(addMilestoneButtonLocator);}

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

}
