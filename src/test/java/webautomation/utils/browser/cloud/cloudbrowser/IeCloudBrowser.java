package webautomation.utils.browser.cloud.cloudbrowser;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import webautomation.utils.browser.cloud.CloudBrowser;
import webautomation.utils.browser.cloud.SauceLabCredentials;

import java.net.MalformedURLException;
import java.net.URL;

public class IeCloudBrowser implements CloudBrowser {
    @Override
    public RemoteWebDriver getDriver(String platform, String browserVersion, String resolution) throws MalformedURLException {
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        ieCapabilities.setCapability("platform", platform);
        ieCapabilities.setCapability("version", browserVersion);
        ieCapabilities.setCapability("screenResolution", resolution);
        return new RemoteWebDriver(new URL(String.format("http://%s:%s@ondemand.eu-central-1.saucelabs.com:80/wd/hub",
                new SauceLabCredentials().getUserName(),
                new SauceLabCredentials().getSauceKey())),
                ieCapabilities);
    }
}
