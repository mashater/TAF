package tests;

import BaseEntities.BaseTest;
import configurations.ReadProperties;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.WaitsService;

import java.time.Duration;

public class MilestonesTest extends BaseTest {

    @Test
    public void createNewMilestoneTest() throws InterruptedException {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        ergProjectStep.openMilestonePage();
        milestonesStep.createAndSaveMilestone();
        Assert.assertTrue(milestonesOfErgProjectPage.getSuccessMassage().isDisplayed());
    }

    @Test (dependsOnMethods = "createNewMilestoneTest")
    public void readMilestoneTest(){
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        milestonesOfErgProjectPage.openPageByUrl();
        Assert.assertTrue(milestonesStep.readMilestone().getNameElement().isDisplayed());

    }

    @Test (dependsOnMethods = "readMilestoneTest")
    public void updateMilestoneTest(){
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        milestonesOfErgProjectPage.openPageByUrl();
        milestonesStep.editMilestone();
        Assert.assertTrue(milestonesOfErgProjectPage.getSuccessMassage().isDisplayed());

    }

    @Test (dependsOnMethods = "updateMilestoneTest")
    public void deleteMilestoneTest(){
        WaitsService wait = new WaitsService(driver, Duration.ofSeconds(ReadProperties.timeout()));

        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        milestonesOfErgProjectPage.openPageByUrl();
        milestonesStep.deleteMilestone();

        WebElement successMassage = wait.waitForVisibility(milestonesOfErgProjectPage.getSuccessMassage());
        Assert.assertTrue(successMassage.isDisplayed());

    }

}
