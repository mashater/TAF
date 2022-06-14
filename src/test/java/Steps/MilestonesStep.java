package Steps;

import BaseEntities.BaseStep;
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
        milestoneEditPage.getNameInput().click();
        milestoneEditPage.getNameInput().sendKeys(firstMilestoneName);
        milestoneEditPage.getAddAndSaveButton().click();
       return milestonesOfErgProjectPage;


    }

    public MilestonePage readMilestone(){
        milestonesOfErgProjectPage.getNameOfFirstMilestone().click();
        return milestonePage;
    }

    public MilestonesOfErgProjectPage editMilestone(){
        milestonesOfErgProjectPage.getNameOfFirstMilestone().click();
        milestonePage.getEditButton().click();
        milestoneEditPage.getNameInput().clear();
        milestoneEditPage.getNameInput().sendKeys(secondMilestoneName);
        milestoneEditPage.getAddAndSaveButton().click();
        return milestonesOfErgProjectPage;

}

    public MilestonesOfErgProjectPage deleteMilestone(){
        milestonesOfErgProjectPage.openPageByUrl();
        milestonesOfErgProjectPage.getDeleteButton().click();
        milestonesOfErgProjectPage.getConfirmationDeleteButton().click();

        return milestonesOfErgProjectPage;
    }


}
