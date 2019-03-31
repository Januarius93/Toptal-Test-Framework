package webautomation.utils.browser.remote.linux;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import webautomation.utils.browser.Browser;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteChromeLinux implements Browser {
    @Override
    public WebDriver getDriver() throws MalformedURLException {
        DesiredCapabilities dc = DesiredCapabilities.edge();
        dc.setPlatform(Platform.LINUX);
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),dc);
    }
}
