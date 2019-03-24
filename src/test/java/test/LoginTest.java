package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver webDriver;
    @Test
    public void test(){
        webDriver = new ChromeDriver();
    }
}
