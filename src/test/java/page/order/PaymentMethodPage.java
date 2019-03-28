package page.order;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.LoginPage;

public class PaymentMethodPage extends UserFormPage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);
    @FindBy(xpath = "//li[contains(@data-option-type,'payment')]")
    private
    WebElement bankTransferOption;

    @FindBy(className = "main-submit-container")
    private
    WebElement approvePaymentMethod;

    @FindBy(xpath = "//div[contains(text(),'Dane osobowe')]")
    private
    WebElement userFormButton;


    public PaymentMethodPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PaymentMethodPage chooseBankTransfer() {
        log.info("choosing bank transfer: ");
        freezeExecution(3);
        clickInElement(bankTransferOption);
        waitForExpectedCondition(ExpectedConditions.attributeContains(bankTransferOption, "class", "active"));
        return this;
    }

    public PaymentMethodPage continueOrder() {
        log.info("shopping is continued");
        scrollToElement(approvePaymentMethod);
        waitForExpectedCondition(ExpectedConditions.visibilityOf(approvePaymentMethod));
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(approvePaymentMethod));
        clickInElement(approvePaymentMethod);
        return this;
    }

    public PaymentMethodPage goToUserForm() {
        log.info("moving to user form: ");
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(userFormButton));
        clickInElement(userFormButton);
        return this;
    }

}
