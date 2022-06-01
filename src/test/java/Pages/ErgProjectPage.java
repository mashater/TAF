package Pages;

import BaseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErgProjectPage extends BasePage {
    private final static String pagePath = "/index.php?/projects/overview/3";
    public ErgProjectPage ergProjectPage;

    private By nameOfProjectLocator = By.cssSelector(".content-header-title");

    public ErgProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return nameOfProjectLocator;
    }
    public WebElement nameOfProject ()
    {return driver.findElement(nameOfProjectLocator);}

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

}
