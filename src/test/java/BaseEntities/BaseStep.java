package BaseEntities;


import Pages.*;
import org.openqa.selenium.WebDriver;

public class BaseStep {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected ProjectsPage projectsPage;
    protected MilestonesPage milestonesPage;
    protected ErgProjectPage ergProjectPage;


    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        projectsPage = new ProjectsPage(driver);
        milestonesPage= new MilestonesPage(driver);
        ergProjectPage= new ErgProjectPage(driver);
    }
}
