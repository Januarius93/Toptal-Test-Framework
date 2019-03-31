package webautomation.utils.browser;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowser implements Browser {
    @Override
    public WebDriver getDriver() {
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver();
    }
}