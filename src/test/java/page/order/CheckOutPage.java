package page.order;

import assertion.CheckOutPageAssertion;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPage;
import page.LoginPage;


public class CheckOutPage extends AbstractPage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    @FindBy(className = "main-submit-container")
    private
    WebElement orderButton;

    public CheckOutPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getOrderButtonName() {
        log.info("getting order button name: ");
        return orderButton.getText();
    }

    public boolean isOrderButtonEnabled() {
        log.info("checking is enabled: ");
        return orderButton.isEnabled();
    }

    public CheckOutPage assertThatWatchCanBeBought(CheckOutPageAssertion checkOutPageAssertion, String expectedButtonName) {
        checkOutPageAssertion
                .assertThatWatchCanBeBought(expectedButtonName)
                .assertThatWatchCanBeBought();
        return this;
    }


}
