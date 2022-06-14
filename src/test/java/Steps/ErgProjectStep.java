package Steps;

import BaseEntities.BaseStep;
import Pages.ErgProjectPage;
import Pages.MilestoneEditPage;
import org.openqa.selenium.WebDriver;

public class ErgProjectStep extends BaseStep {
    public ErgProjectStep(WebDriver driver) {
        super(driver);
    }

    public ErgProjectPage navigateToErgProjectPage() {
        ergProjectPage.openPageByUrl();
        return ergProjectPage;
    }

    public MilestoneEditPage openMilestonePage() {
        ergProjectPage.openPageByUrl();
        ergProjectPage.getAddMilestoneButton().click();

        return milestoneEditPage;


    }
}
