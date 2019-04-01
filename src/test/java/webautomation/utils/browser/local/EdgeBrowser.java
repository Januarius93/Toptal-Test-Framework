package webautomation.utils.browser.local;

import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import webautomation.utils.browser.Browser;

public class EdgeBrowser implements Browser {
    @Override
    public WebDriver getDriver() {
        EdgeDriverManager.getInstance().setup();
        return new EdgeDriver();
    }
}