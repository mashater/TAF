package BaseEntities;

import Pages.MilestonesOfErgProjectPage;
import Steps.ErgProjectStep;
import Steps.MilestonesStep;
import configurations.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import services.BrowsersService;
import Steps.LoginStep;
import Steps.NavigationStep;

public class BaseTest {
    protected WebDriver driver;
    protected LoginStep loginStep;
    protected NavigationStep navigationStep;
    protected ErgProjectStep ergProjectStep;
    protected MilestonesStep milestonesStep;
    protected MilestonesOfErgProjectPage milestonesOfErgProjectPage;

    @BeforeMethod
    public void setup() {
        driver = new BrowsersService().getDriver();

        loginStep = new LoginStep(driver);
        navigationStep = new NavigationStep(driver);
        ergProjectStep = new ErgProjectStep(driver);
        milestonesStep = new MilestonesStep(driver);
        milestonesOfErgProjectPage = new MilestonesOfErgProjectPage(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
