package tests;

import BaseEntities.BaseTest;
import configurations.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestonesTest extends BaseTest {

    @Test
    public void createNewMilestoneTest() throws InterruptedException {
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        ergProjectStep.openMilestonePage();
        milestonesStep.createAndSaveMilestone();
        Assert.assertTrue(milestonesOfErgProjectPage.isPageOpened());
                Thread.sleep(4000); // создание milestone

    }

    @Test
    public void readMilestoneTest(){
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        milestonesOfErgProjectPage.openPageByUrl();
        Assert.assertEquals(milestonesStep.readMilestone(), "First");

    }






}
