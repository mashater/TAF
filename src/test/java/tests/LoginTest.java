package tests;

import BaseEntities.BaseTest;
import configurations.ReadProperties;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void successLoginTest() {
        Assert.assertTrue(
                loginStep.successLogin(
                        ReadProperties.username(),
                        ReadProperties.password()
                )
                        .isPageOpened()
        );
    }

    @Test
    public void incorrectEmailLoginTest() {
        Assert.assertEquals(
                loginStep.incorrectLogin("sdsd", ReadProperties.password()).errorText.getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");

        Assert.assertTrue(false); //для скриншота неверное значение
    }

    @Test
    public void incorrectPswLoginTest() {
        Assert.assertEquals(
                loginStep.incorrectLogin(ReadProperties.username(), "123").errorText.getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "Неверное сообщение об ошибке");
    }
}
