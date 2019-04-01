package webautomation.utils.browser.remote.windows.remotewindows;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import webautomation.utils.browser.Browser;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteFirefoxWindows10 implements Browser {
    @Override
    public WebDriver getDriver() throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.firefox();
        dc.setPlatform(Platform.WINDOWS);
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
    }
}
