package Pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    // Блок описания селекторов для элементов
    @FindBy (id="name")
    public WebElement emailInput;  //pagefactory
    @FindBy (id="password")
    public WebElement pswInput;
    @FindBy (id="button_primary")
    public WebElement logInButton;
    @FindBy (className="error-text")
    public WebElement errorText ;

    // Блок иницализации
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected WebElement getPageIdentifier() {
        return emailInput;
    }

    // Блок атомарных методов
    //public WebElement getEmailInput() {return waitsService.waitForExists(emailInputLocator);} не нужен при pagefactory
    //public WebElement getPswInput() {return waitsService.waitForExists(pswInputLocator);}
    //public WebElement getLogInButton() {return waitsService.waitForExists(logInButtonLocator);}
    //public WebElement getErrorTextElement() { return waitsService.waitForExists(errorTextLocator);}
}
