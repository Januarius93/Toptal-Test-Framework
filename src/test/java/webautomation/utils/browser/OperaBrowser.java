package webautomation.utils.browser;

import io.github.bonigarcia.wdm.OperaDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class OperaBrowser implements Browser {
    @Override
    public WebDriver getDriver() {
        WebDriverManager.operadriver().setup();
        return new OperaDriver();
    }
}