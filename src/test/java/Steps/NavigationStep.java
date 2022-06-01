package Steps;

import BaseEntities.BaseStep;
import Pages.MilestonesPage;
import org.openqa.selenium.WebDriver;
import Pages.ProjectsPage;

public class NavigationStep extends BaseStep {

    public NavigationStep(WebDriver driver) {
        super(driver);
    }

    public ProjectsPage navigateToProjectsPage() {
        projectsPage.openPageByUrl();
        return projectsPage;
    }




}
