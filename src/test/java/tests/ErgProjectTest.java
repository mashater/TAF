package tests;

import BaseEntities.BasePage;
import BaseEntities.BaseTest;
import configurations.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErgProjectTest extends BaseTest {

    @Test
    public void validateErgProjectTest(){
        loginStep.successLogin(ReadProperties.username(), ReadProperties.password());
        Assert.assertTrue(ergProjectStep.navigateToErgProjectPage().nameOfProject().isDisplayed());// открыли и проверили стр проекта erg

    }




}
