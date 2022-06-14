package BaseEntities;


import Pages.*;
import org.openqa.selenium.WebDriver;

public class BaseStep {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected ProjectsPage projectsPage;
    protected MilestoneEditPage milestoneEditPage;
    protected ErgProjectPage ergProjectPage;
    protected MilestonesOfErgProjectPage milestonesOfErgProjectPage;
    protected MilestonePage milestonePage;


    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        projectsPage = new ProjectsPage(driver);
        milestoneEditPage = new MilestoneEditPage(driver);
        ergProjectPage= new ErgProjectPage(driver);
        milestonesOfErgProjectPage = new MilestonesOfErgProjectPage(driver);
        milestonePage = new MilestonePage(driver);
    }
}
