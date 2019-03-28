package assertion;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page.CheckOutPage;
import page.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckOutPageAssertion extends AbstractAssertion {
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public CheckOutPageAssertion(WebDriver webDriver) {
        super(webDriver);
    }


    public CheckOutPageAssertion assertThatWatchCanBeBought(String expectedButtonName) {
        log.info("assertion started: ");
        assertThat(new CheckOutPage(getWebDriver()).getOrderButtonName())
                .as("verify if button has correct name").
                isEqualTo(expectedButtonName);
        return this;
    }

    public CheckOutPageAssertion assertThatWatchCanBeBought() {
        log.info("assertion started: ");
        assertThat(new CheckOutPage(getWebDriver()).isOrderButtonEnabled())
                .as("verify is button enabled")
                .isTrue();
        return this;
    }
}
