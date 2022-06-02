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


    public MilestonesOfErgProjectPage createAndSaveMilestone (){
        milestonePage.getNameInput().sendKeys(firstMilestoneName);
        milestonePage.getAddAndSaveButton().click();
       return milestonesOfErgProjectPage;


    }



}
