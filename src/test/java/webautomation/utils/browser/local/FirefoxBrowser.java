package webautomation.utils.browser.local;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import webautomation.utils.browser.Browser;

public class FirefoxBrowser implements Browser {
    @Override
    public WebDriver getDriver() {
        FirefoxDriverManager.getInstance().setup();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setHeadless(true);
        return new FirefoxDriver(firefoxOptions);
    }
}