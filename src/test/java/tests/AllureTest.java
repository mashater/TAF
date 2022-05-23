package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;


@Epic("Allure example")
@Feature("TestNG Support") // обычно указывается в jira
public class AllureTest {

    @Test(description = "Main Test")

    public void testName() {

        Assert.assertTrue(true);
    }

    @Test
    @Description("Some details ")

    public void testName1() {

        Assert.assertTrue(true);
    }

    @Test
    @Severity(SeverityLevel.BLOCKER) // приоритет

    public void testName2() {

        Assert.assertTrue(true);
    }

    @Test
    @Story("Base support function")

    public void testName3() {

        Assert.assertTrue(true);
    }
    @Test
   public void testName4() {
        step("Admin");
        Assert.assertTrue(true);
    }
    @Step ("User name {user}") // используем объект
    private void step (String user){
        System.out.println(user);
    }

    @Test
    @Issue("ID- 123") // ccылка на баг
    public void testIssue() {

        Assert.assertTrue(true);
    }

    @Test
    @TmsLink("TMS - 532") //ссылка на тмс,т.е. тест кейс
    public void testTMS() {
        Assert.assertTrue(true);
    }

    @Test
    @Link ("https://example.org")//указывает ссылку в текстовом виде
    @Link (name = "allureLink", type = "myLink", url = "https://onliner.by") // с переходом по ссылке
    public void testLink() {
        Assert.assertTrue(true);
    }

}
