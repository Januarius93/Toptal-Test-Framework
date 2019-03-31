package webautomation.utils.browser;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface Browser {
    WebDriver getDriver() throws MalformedURLException;
}
