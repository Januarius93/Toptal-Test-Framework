package utils.browser;

import io.github.bonigarcia.wdm.OperaDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class OperaBrowser implements Browser {
    @Override
    public WebDriver getDriver() {
        WebDriverManager.edgedriver().setup();
        return new OperaDriver();
    }
}