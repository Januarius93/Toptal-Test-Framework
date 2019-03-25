package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.log4j.*;

public abstract class AbstractPage {
    private static final Logger log = LogManager.getLogger(AbstractPage.class);
    private WebDriver webDriver;
    private static int WAIT_TIMEOUT = 30;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    void waitForExpectedCondition(ExpectedCondition<?> expectedCondition) {
        log.info("wait until: " + expectedCondition);
        new WebDriverWait(webDriver, WAIT_TIMEOUT).until(expectedCondition);
    }

    public String getUrl() {
        log.info(":obtaining URL");
        return webDriver.getCurrentUrl();
    }

    void clickInElement(WebElement webElement) {
        webElement.click();
    }

    protected WebDriver getWebDriver() {
        return webDriver;
    }

}
