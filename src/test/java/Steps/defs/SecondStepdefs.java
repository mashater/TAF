package Steps.defs;

import BaseEntities.BaseCucumberTest;
import configurations.ReadProperties;
import io.cucumber.java.en.When;

public class SecondStepdefs extends BaseCucumberTest {
    private BaseCucumberTest baseCucumberTest;

    public SecondStepdefs(BaseCucumberTest baseCucumberTest) {
        this.baseCucumberTest = baseCucumberTest;
    }

    @When("loginpage is open")
    public void loginpageIsOpen() {
        baseCucumberTest.driver.get(ReadProperties.getUrl());
    }
}
