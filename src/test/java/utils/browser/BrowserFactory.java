package utils.browser;

import org.openqa.selenium.WebDriver;


public class BrowserFactory {
    private static final String BROWSER = System.getProperty("browser");
    private static WebDriver webDriver;

    public static WebDriver getBrowser() {
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
            default:
                webDriver = new ChromeBrowser().getDriver();
                break;
        }
        return webDriver;
    }
}
