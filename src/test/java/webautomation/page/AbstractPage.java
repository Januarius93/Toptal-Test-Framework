package webautomation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.log4j.*;

import java.util.List;
import java.util.concurrent.TimeUnit;


public abstract class AbstractPage {
    private static final Logger log = LogManager.getLogger(AbstractPage.class);
    protected WebDriver webDriver;
    protected Actions action;
    private static int WAIT_TIMEOUT = 30;

    public AbstractPage(WebDriver webDriver) {
        action = new Actions(webDriver);
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    protected void waitForExpectedCondition(ExpectedCondition<?> expectedCondition) {
        log.info("wait until : " + expectedCondition);
        new WebDriverWait(webDriver, WAIT_TIMEOUT).until(expectedCondition);
    }

    public String getUrl() {
        log.info("obtaining URL :");
        return webDriver.getCurrentUrl();
    }

    protected void clickInElement(WebElement element) {
        log.info("clicking: " + element);
        element.click();
    }

    protected void typeIntoInput(WebElement input, String text) {
        log.info(String.format("typing %s into: %s", text, input));
        input.sendKeys(text);
    }

    protected void clearInput(WebElement input) {
        log.info("cleaning up input for: " + input);
        input.clear();
    }

    protected void scrollToElement(WebElement element) {
        log.info("scrolling into: " + element);
        action.moveToElement(element).build().perform();
    }

    public AbstractPage hitButton(CharSequence key) {
        log.info("enter hit: ");
        action.sendKeys(key).release().build().perform();
        return this;
    }

    public void waitInTime(int time, TimeUnit unit) {
        webDriver.manage().timeouts().implicitlyWait(time, unit);
    }

    public void freezeExecution(int seconds) {
        log.warn("Freezing execution for: " + seconds + " [s]");
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<WebElement> getElementsByClassName(String locator) {
        return webDriver.findElements(By.className(locator));
    }
    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0,250)");
    }

    protected WebDriver getWebDriver() {
        return webDriver;
    }

}
