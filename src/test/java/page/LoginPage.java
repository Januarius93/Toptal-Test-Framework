package page;

import assertion.LoginPageAssertion;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends AbstractPage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);
    @FindBy(className = "icon-user-circle")
    WebElement userButton;
    @FindBy(id = "identity")
    WebElement loginInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "submit")
    WebElement loginButton;
    @FindBy(className = "message-error")
    WebElement messageErrorPopOut;
    @FindBy(xpath = "//a[contains(text(), 'Zobacz profil')]")
    WebElement seeProfileOption;
    @FindBy(className = "closeImg")
    WebElement closeLogin;

    private static String SEE_PROFILE_XPATH = "//a[contains(text(), 'Zobacz profil')]";


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    public LoginPage login(String userName, String password) {
        log.info("login start: ");
        waitForExpectedCondition(ExpectedConditions.invisibilityOf(messageErrorPopOut));
        waitForExpectedCondition(ExpectedConditions.visibilityOf(loginButton));
        loginInput.sendKeys(userName);
        waitForExpectedCondition(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
        loginButton.click();
        return this;
    }

    public LoginPage emptyLogin() {
        log.info("login start: ");
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return this;
    }

    public LoginPage clickToSeeProfileOption() {
        log.info("user button click");
        waitForExpectedCondition(ExpectedConditions.presenceOfElementLocated(By.xpath(SEE_PROFILE_XPATH)));
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(userButton));
        clickInElement(userButton);
        return this;
    }

    public boolean getPopOutConfirmation() {
        log.info("getting popout: ");
        waitForExpectedCondition(ExpectedConditions.visibilityOf(messageErrorPopOut));
        return !messageErrorPopOut.getAttribute("style").contains("none");
    }

    public LoginPage closeLoginPopOut() {
        log.info("closing login popout: ");
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(closeLogin));
        clickInElement(closeLogin);
        return this;
    }

    public boolean getSeeProfileOption() {
        log.info("see profile");
        return seeProfileOption.isDisplayed();
    }

    public LoginPage assertIfLoginProcessFailed(LoginPageAssertion loginPageAssertion){
        loginPageAssertion.assertIfLoginProcessFailed();
        return this;
    }

    public LoginPage assertIfLogInSuccessful(LoginPageAssertion loginPageAssertion){
        loginPageAssertion.assertIfLogInSuccessful();
        return this;
    }


}
