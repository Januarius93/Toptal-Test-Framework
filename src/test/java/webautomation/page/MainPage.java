package webautomation.page;

import webautomation.assertion.MainPageAssertion;
import webautomation.enums.SearchCriteria;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends LoginPage {
    private CharSequence key = Keys.ENTER;
    private static final Logger log = LogManager.getLogger(LoginPage.class);
    private static final String EXPECTED_URL = "https://www.e-zegarki.pl/";
    @FindBy(className = "icon-user-circle")
    private
    WebElement userButton;
    @FindBy(xpath = "//a[contains(text(), 'Zaloguj')]")
    private
    WebElement loginOption;
    @FindBy(id = "autocomplete")
    private
    WebElement searchInput;
    @FindBy(className = "navbar-brand")
    private
    WebElement mainPageNav;


    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPage clickUserButton() {
        log.info("user button click: ");
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(userButton));
        clickInElement(userButton);
        return this;
    }

    public MainPage clickLoginOption() {
        log.info("login option: ");
        freezeExecution(1);
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(loginOption));
        loginOption.click();
        return this;
    }

    public MainPage typeSearchCriteria(SearchCriteria searchCriteria) {
        log.info("typing into search: ");
        waitForExpectedCondition(ExpectedConditions.visibilityOf(searchInput));
        typeIntoInput(searchInput, searchCriteria.getCriteria());
        return this;
    }

    public MainPage hitSearch() {
        log.info(": search");
        hitButton(key);
        freezeExecution(5);
        return this;
    }

    public void goToMainPage() {
        log.info(": method start");
        clickInElement(mainPageNav);
    }

    public LoginPage assertIfProperPage(MainPageAssertion mainPageAssertion) {
        mainPageAssertion.assertIfProperPage(EXPECTED_URL);
        return this;
    }


}
