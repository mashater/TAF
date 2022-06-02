package Steps;

import BaseEntities.BaseStep;
import Pages.ErgProjectPage;
import Pages.MilestonePage;
import org.openqa.selenium.WebDriver;

public class ErgProjectStep extends BaseStep {
    public ErgProjectStep(WebDriver driver) {
        super(driver);
    }

    public ErgProjectPage navigateToErgProjectPage() {
        ergProjectPage.openPageByUrl();
        return ergProjectPage;
    }

    public MilestonePage openMilestonePage() {
        ergProjectPage.openPageByUrl();
        ergProjectPage.getAddMilestoneButton().click();

        return milestonePage;


    }
}
