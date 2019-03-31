package webautomation.utils.browser.remote.linux;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import webautomation.utils.browser.Browser;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteOperaLinux implements Browser {
    @Override
    public WebDriver getDriver() throws MalformedURLException {
        OperaOptions operaOptions = new OperaOptions();
        DesiredCapabilities capabilities = new DesiredCapabilities().opera();
//        operaOptions.addArguments("start-maximized");
//        operaOptions.addArguments("disable-infobars");
//        operaOptions.addArguments("--disable-extensions");
//        operaOptions.addArguments("--disable-gpu");
//        operaOptions.addArguments("--disable-dev-shm-usage");
//        operaOptions.addArguments("--no-sandbox");
//        operaOptions.addArguments("--headless");
        capabilities.setCapability(OperaOptions.CAPABILITY,operaOptions);
        capabilities.setBrowserName("opera");
        capabilities.setPlatform(Platform.WINDOWS);
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    }
}
