package Steps;

import BaseEntities.BaseStep;
import Pages.MilestoneEditPage;
import Pages.MilestonePage;
import Pages.MilestonesOfErgProjectPage;
import org.openqa.selenium.WebDriver;

public class MilestonesStep extends BaseStep {
    public String firstMilestoneName = "First";
    public String secondMilestoneName = "Second";


    public MilestonesStep(WebDriver driver) {
        super(driver);
    }


    public MilestonesOfErgProjectPage navigateToMilestonesOfErgProjPage (){
        milestonesOfErgProjectPage.openPageByUrl();
        return milestonesOfErgProjectPage;
    }


    public MilestonesOfErgProjectPage createAndSaveMilestone (){
        milestoneEditPage.getNameInput().sendKeys(firstMilestoneName);
        milestoneEditPage.getAddAndSaveButton().click();
       return milestonesOfErgProjectPage;


    }

    public MilestonePage readMilestone(){
        milestonesOfErgProjectPage.getNameOfMilestone().click();
        return milestonePage;


    }



}
