package tests;

import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configurations.ReadProperties;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.File;
import java.time.Duration;
import java.time.temporal.TemporalUnit;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTest {

    @BeforeSuite
    public void setupBrowser() {
        Configuration.baseUrl = ReadProperties.getUrl();
        Configuration.browser = ReadProperties.browserName();
        Configuration.browserSize = "1960x1080";
        //Configuration.assertionMode = AssertionMode.SOFT; // выполняются все проверки
        //Configuration.driverManagerEnabled = false;
        //Configuration.fastSetValue = true; // имитация скорости работы пользователя
        //Configuration.headless = true;
        Configuration.reportsFolder = "target/screens";
        Configuration.pageLoadTimeout = Duration.ofSeconds(30).toMillis();
        Configuration.timeout = Duration.ofSeconds(20).toMillis();;

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // or for fine-tuning:
/*
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );
*/
    }



    @Test
    public void poSelenideTest() {
        open(ReadProperties.getUrl());

        LoginPage loginPage = new LoginPage();

        loginPage.username.setValue(ReadProperties.username());
        loginPage.password.setValue(ReadProperties.password());
        loginPage.loginButton.click();

        $(".page_title").shouldBe(visible).shouldHave(text("All Projects1"));
    }


}
