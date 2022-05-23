package Steps;

import BaseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import Pages.DashboardPage;
import Pages.LoginPage;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }

    @Step("Успешный логин с {email}/{psw}")
    public DashboardPage successLogin(String email, String psw) {
        login(email, psw);

        return dashboardPage;
    }

    @Step("Неудачный логин с {email}/{psw}")
    public LoginPage incorrectLogin(String email, String psw) {
        login(email, psw);

        return loginPage;
    }

    private void login(String email, String psw) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPswInput().sendKeys(psw);
        loginPage.getLogInButton().click();
    }

    public LoginPage logout() {

        return loginPage;
    }
}
