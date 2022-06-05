package Steps;

import BaseEntities.BaseStep;
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
        milestonePage.getNameInput().sendKeys(firstMilestoneName);
        milestonePage.getAddAndSaveButton().click();
       return milestonesOfErgProjectPage;


    }

    public MilestonesOfErgProjectPage readMilestone(){
        milestonesOfErgProjectPage.NameOfMilestone().getText();
        return milestonesOfErgProjectPage;


    }



}
