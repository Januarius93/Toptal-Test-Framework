package webautomation.utils.browser.cloud.cloudbrowser;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import webautomation.utils.browser.cloud.CloudBrowser;
import webautomation.utils.browser.cloud.SauceLabCredentials;

import java.net.MalformedURLException;
import java.net.URL;

public class EdgeCloudBrowser implements CloudBrowser {

    @Override
    public RemoteWebDriver getDriver(String platform, String browserVersion, String resolution) throws MalformedURLException {
        DesiredCapabilities edgeCapabilities = DesiredCapabilities.edge();
        edgeCapabilities.setCapability("platform", platform);
        edgeCapabilities.setCapability("version", browserVersion);
        edgeCapabilities.setCapability("screenResolution", resolution);
        return new RemoteWebDriver(new URL(String.format("http://%s:%s@ondemand.eu-central-1.saucelabs.com:80/wd/hub",
                new SauceLabCredentials().getUserName(),
                new SauceLabCredentials().getSauceKey())),
                edgeCapabilities);
    }
}
