package Pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MilestonesOfErgProjectPage extends BasePage {
    public MilestonePage milestonePage;
    private final static String pagePath = "/index.php?/milestones/overview/3";

    public By AddMilestoneButtonLocator = By.xpath("//span[contains (text(), 'Add Milestone')]");
    public By NameOfMilestoneLocator = By.xpath("//a[text()='First']");


    public MilestonesOfErgProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return AddMilestoneButtonLocator;
    }
    // Блок атомарных методов
    public WebElement AddMilestoneButton() {return driver.findElement(AddMilestoneButtonLocator);}
    public WebElement NameOfMilestone() {return driver.findElement(NameOfMilestoneLocator);}


    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }


}
