package webautomation.test;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import webautomation.utils.PropertyFileReader;
import webautomation.utils.browser.local.BrowserFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;

public abstract class AbstractTest {
    private String url;
    protected String login;
    protected String password;
    private Properties properties;
    protected WebDriver driver;
    private PropertyFileReader propertyFileReader;


    protected void set() throws IOException {
        setUpBrowser();
        setUpConfig();
        maximizeBrowser();
        gotToUrl();
    }

    private void setUpConfig() {
        propertyFileReader = new PropertyFileReader().readPropertyFile();
        properties = propertyFileReader.getProperties();
        this.url = properties.getProperty("url");
        this.login = properties.getProperty("login");
        this.password = properties.getProperty("password");
    }

    private void setUpBrowser() throws MalformedURLException {
        driver = BrowserFactory.getBrowser();
    }

    private void maximizeBrowser() {
        driver.manage().window().maximize();
    }

    private void gotToUrl() {
        driver.get(url);
    }

    @AfterClass
    public void tearDownAfterTest() {
        driver.close();
    }

    @AfterSuite
    public void tearDownAfterSuite() {
        try {
            driver.quit();
        }
        catch (NoSuchSessionException e){

        }
    }


}
