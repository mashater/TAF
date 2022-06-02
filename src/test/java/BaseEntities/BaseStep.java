package BaseEntities;


import Pages.*;
import org.openqa.selenium.WebDriver;

public class BaseStep {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected ProjectsPage projectsPage;
    protected MilestonePage milestonePage;
    protected ErgProjectPage ergProjectPage;
    protected MilestonesOfErgProjectPage milestonesOfErgProjectPage;


    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        projectsPage = new ProjectsPage(driver);
        milestonePage= new MilestonePage(driver);
        ergProjectPage= new ErgProjectPage(driver);
        milestonesOfErgProjectPage = new MilestonesOfErgProjectPage(driver);
    }
}
