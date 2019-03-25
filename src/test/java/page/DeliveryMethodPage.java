package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeliveryMethodPage extends PaymentMethodPage {

    @FindBy(className = "c-gls active")
    WebElement glsDelivery;

    @FindBy(className = "main-submit-container")
    WebElement approveDeliveryMethod;

    DeliveryMethodPage(WebDriver webDriver) {
        super(webDriver);
    }

    public DeliveryMethodPage chooseGlsDelivery(){
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(glsDelivery));
        clickInElement(glsDelivery);
        return this;
    }

    public DeliveryMethodPage continueOrder(){
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(approveDeliveryMethod));
        clickInElement(approveDeliveryMethod);
        return this;
    }

}
