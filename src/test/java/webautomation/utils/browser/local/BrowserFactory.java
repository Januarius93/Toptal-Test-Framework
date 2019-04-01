package webautomation.utils.browser.local;

import org.openqa.selenium.WebDriver;
import webautomation.utils.browser.cloud.CloudBrowserFactory;
import webautomation.utils.browser.remote.linux.remotelinux.RemoteChromeLinux;
import webautomation.utils.browser.remote.linux.remotelinux.RemoteFirefoxLinux;
import webautomation.utils.browser.remote.linux.remotelinux.RemoteOperaLinux;
import webautomation.utils.browser.remote.windows.remotewindows.RemoteChromeWindows10;
import webautomation.utils.browser.remote.windows.remotewindows.RemoteEdgeWindows10;
import webautomation.utils.browser.remote.windows.remotewindows.RemoteFirefoxWindows10;
import webautomation.utils.browser.remote.windows.remotewindows.RemoteOperaWindows10;

import java.net.MalformedURLException;


public class BrowserFactory {
    private static final String BROWSER = System.getProperty("browser");
    private static final String IS_CLOUD = System.getProperty("isCloud");
    private static final String PLATFORM = System.getProperty("platform");
    private static final String BROWSER_VERSION = System.getProperty("browserVersion");
    private static final String RESOLUTION = System.getProperty("resolution");


    private static WebDriver webDriver;

    public static WebDriver getBrowser() throws MalformedURLException {

        if (IS_CLOUD.equalsIgnoreCase("true")) {
            return new CloudBrowserFactory().getEnvironment(BROWSER, PLATFORM, BROWSER_VERSION, RESOLUTION);
        }

        switch (BROWSER) {
            case "chrome":
                webDriver = new ChromeBrowser().getDriver();
                break;
            case "firefox":
                webDriver = new FirefoxBrowser().getDriver();
                break;
            case "opera":
                webDriver = new OperaBrowser().getDriver();
                break;
            case "edge":
                webDriver = new EdgeBrowser().getDriver();
                break;
            case "remoteChromeWindows10":
                webDriver = new RemoteChromeWindows10().getDriver();
                break;
            case "remoteChromeLinux":
                webDriver = new RemoteChromeLinux().getDriver();
                break;
            case "remoteFirefoxWindows10":
                webDriver = new RemoteFirefoxWindows10().getDriver();
                break;
            case "remoteFirefoxLinux":
                webDriver = new RemoteFirefoxLinux().getDriver();
                break;
            case "remoteEdgeWindows10":
                webDriver = new RemoteEdgeWindows10().getDriver();
                break;
            default:
                webDriver = new ChromeBrowser().getDriver();
                break;
        }
        return webDriver;
    }
}
