package page;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends LoginPage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);
    @FindBy(className = "icon-user-circle")
    WebElement userButton;
    @FindBy(xpath = "//a[contains(text(), 'Zaloguj')]")
    WebElement loginOption;


    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPage clickUserButton() {
        log.info(": user button click action");
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(userButton));
        clickInElement(userButton);
        return this;
    }

    public MainPage clickLoginOption() {
        log.info(": login option");
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(loginOption));
        loginOption.click();
        clickInElement(userButton);
        return this;
    }

}
