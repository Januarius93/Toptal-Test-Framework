package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class DeliveryMethodPage extends PaymentMethodPage {

    @FindBy(className = "c-gls")
    WebElement glsDelivery;

    @FindBy(className = "consignment-icon-gls")
    WebElement glsButton;

    @FindBy(className = "main-submit-container")
    WebElement approveDeliveryMethod;


    DeliveryMethodPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DeliveryMethodPage chooseGlsDelivery() {
        freezeExecution(10);
        clickInElement(glsButton);
        waitForExpectedCondition(ExpectedConditions.attributeContains(glsDelivery, "class", "active"));
        return this;
    }

    public DeliveryMethodPage continueOrder() {
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(approveDeliveryMethod));
        clickInElement(approveDeliveryMethod);
        return this;
    }

}
