package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class First {
    @Test
    public void browserTest (){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\m.terenya\\IdeaProjects\\TAF\\src\\test\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

    }
}
