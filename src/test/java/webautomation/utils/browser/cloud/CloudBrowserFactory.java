package webautomation.utils.browser.cloud;

import org.openqa.selenium.WebDriver;
import webautomation.utils.browser.cloud.cloudbrowser.ChromeCloudBrowser;
import webautomation.utils.browser.cloud.cloudbrowser.EdgeCloudBrowser;
import webautomation.utils.browser.cloud.cloudbrowser.FirefoxCloudBrowser;
import webautomation.utils.browser.cloud.cloudbrowser.IeCloudBrowser;

import java.net.MalformedURLException;

public class CloudBrowserFactory {

    WebDriver webDriver;

    public WebDriver getEnvironment(String browser, String platform, String browserVersion, String resolution) throws MalformedURLException {
        switch (browser) {
            case "chrome":
                webDriver = new ChromeCloudBrowser().getDriver(platform, browserVersion, resolution);
                break;
            case "edge":
                webDriver = new EdgeCloudBrowser().getDriver(platform, browserVersion, resolution);
                break;
            case "firefox":
                webDriver = new FirefoxCloudBrowser().getDriver(platform, browserVersion, resolution);
                break;
            case "ie":
                webDriver = new IeCloudBrowser().getDriver(platform, browserVersion, resolution);
                break;
            default:
                webDriver = new ChromeCloudBrowser().getDriver(platform, browserVersion, resolution);
                break;
        }
        return webDriver;
    }
}
