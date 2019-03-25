package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaymentMethodPage extends AbstractPage {

    @FindBy(className = "payment-icon-przelew")
    WebElement bankTransferOption;

    @FindBy(className = "main-submit-container")
    WebElement approvePaymentMethod;

    public PaymentMethodPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PaymentMethodPage chooseBankTransfer(){
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(bankTransferOption));
        clickInElement(bankTransferOption);
        return this;
    }

    public PaymentMethodPage continueOrder(){
        scrollToElement(approvePaymentMethod);
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(approvePaymentMethod));
        clickInElement(approvePaymentMethod);
        return this;
    }

}
