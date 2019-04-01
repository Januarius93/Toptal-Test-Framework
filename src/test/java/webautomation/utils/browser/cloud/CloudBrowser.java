package webautomation.utils.browser.cloud;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public interface CloudBrowser {
    RemoteWebDriver getDriver(String platform, String browserVersion, String resolution) throws MalformedURLException;
}
