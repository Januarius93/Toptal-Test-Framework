package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import utils.PropertyFileReader;
import utils.browser.Browser;
import utils.browser.BrowserFactory;

import java.io.IOException;
import java.util.Properties;

public abstract class AbstractTest {
    String url;
    String login;
    String password;
    Properties properties;
    WebDriver driver;
    private PropertyFileReader propertyFileReader;

    void set() throws IOException {
        setUpBrowser();
        setUpConfig();
        maximizeBrowser();
        gotToUrl();
    }

    private void setUpConfig() throws IOException {
        propertyFileReader = new PropertyFileReader().readPropertyFile();
        properties = propertyFileReader.getProperties();
        this.url = properties.getProperty("url");
        this.login = properties.getProperty("login");
        this.password = properties.getProperty("password");
    }

    private void setUpBrowser() {
        driver = BrowserFactory.getBrowser();
    }

    private void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    private void gotToUrl() {
        driver.get(url);
    }

    @AfterSuite
    public void tearDownAfterSuite() {
        driver.quit();
    }


}
