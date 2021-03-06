package webautomation.utils.browser.local;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import webautomation.utils.browser.Browser;

public class ChromeBrowser implements Browser {

    WebDriver webDriver;

    @Override
    public WebDriver getDriver() {
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox"); //
        options.addArguments("--headless"); //
        options.addArguments("window-size=1024,768"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.setExperimentalOption("useAutomationExtension", false);
        return new ChromeDriver(options);
    }
}