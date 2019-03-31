package webautomation.utils.browser;

import org.openqa.selenium.WebDriver;
import webautomation.utils.browser.remote.linux.RemoteChromeLinux;
import webautomation.utils.browser.remote.linux.RemoteFirefoxLinux;
import webautomation.utils.browser.remote.windows.RemoteChromeWindows10;
import webautomation.utils.browser.remote.windows.RemoteFirefoxWindows10;

import java.net.MalformedURLException;


public class BrowserFactory {
    private static final String BROWSER = System.getProperty("browser");
    private static WebDriver webDriver;

    public static WebDriver getBrowser() throws MalformedURLException {
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
            case "remoteChromeLinux":
                webDriver = new RemoteChromeLinux().getDriver();
                break;
            case "remoteFirefoxLinux":
                webDriver = new RemoteFirefoxLinux().getDriver();
                break;
            case "remoteChromeWindows10":
                webDriver = new RemoteChromeWindows10().getDriver();
                break;
            case "remoteFirefoxWindows10":
                webDriver = new RemoteFirefoxWindows10().getDriver();
                break;
            default:
                webDriver = new ChromeBrowser().getDriver();
                break;
        }
        return webDriver;
    }
}
