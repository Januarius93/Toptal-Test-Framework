package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.log4j.*;

import static org.openqa.selenium.Keys.ENTER;


public abstract class AbstractPage {
    private static final Logger log = LogManager.getLogger(AbstractPage.class);
    WebDriver webDriver;
    Actions action;
    private static int WAIT_TIMEOUT = 30;

    public AbstractPage(WebDriver webDriver) {
        action = new Actions(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    void waitForExpectedCondition(ExpectedCondition<?> expectedCondition) {
        log.info("wait until: " + expectedCondition);
        new WebDriverWait(webDriver, WAIT_TIMEOUT).until(expectedCondition);
    }

    public String getUrl() {
        log.info(": obtaining URL");
        return webDriver.getCurrentUrl();
    }

    void clickInElement(WebElement element) {
        log.info(": clicking");
        element.click();
    }

    void typeIntoInput(WebElement input, String text) {
        log.info(": typing into");
        input.sendKeys(text);
    }

    public AbstractPage hitButton(CharSequence key) {
        action.sendKeys(key).release().build().perform();
        return this;
    }

    protected WebDriver getWebDriver() {
        return webDriver;
    }

}
