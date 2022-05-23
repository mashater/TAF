package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Allure example")
@Feature("TestNG Support") // обычно указывается в jira
public class EpicTest {

    @Test
    @Story("Base support function")
    public void testName3() {
        Assert.assertTrue(true);
    }
}
