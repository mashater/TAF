package BaseEntities;


import Pages.MilestonesPage;
import org.openqa.selenium.WebDriver;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.ProjectsPage;

public class BaseStep {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected ProjectsPage projectsPage;
    protected MilestonesPage milestonesPage;


    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        projectsPage = new ProjectsPage(driver);
        milestonesPage= new MilestonesPage(driver);
    }
}
