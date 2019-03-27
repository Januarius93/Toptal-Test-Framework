package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentMethodPage extends UserFormPage {

    @FindBy(xpath = "//li[contains(@data-option-type,'payment')]")
    WebElement bankTransferOption;

    @FindBy(className = "main-submit-container")
    WebElement approvePaymentMethod;

    @FindBy(xpath = "//div[contains(text(),'Dane osobowe')]")
    WebElement userFormButton;


    public PaymentMethodPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PaymentMethodPage chooseBankTransfer() {
        freezeExecution(3);
        clickInElement(bankTransferOption);
        waitForExpectedCondition(ExpectedConditions.attributeContains(bankTransferOption, "class", "active"));
        return this;
    }

    public PaymentMethodPage continueOrder() {
        scrollToElement(approvePaymentMethod);
        waitForExpectedCondition(ExpectedConditions.visibilityOf(approvePaymentMethod));
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(approvePaymentMethod));
        clickInElement(approvePaymentMethod);
        return this;
    }

    public PaymentMethodPage goToUserForm() {
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(userFormButton));
        clickInElement(userFormButton);
        return this;
    }

}
