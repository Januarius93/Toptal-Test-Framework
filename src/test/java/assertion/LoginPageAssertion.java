package assertion;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page.LoginPage;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginPageAssertion extends AbstractAssertion {
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public LoginPageAssertion(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPageAssertion assertIfLoginProcessFailed() {
        log.info("assertion started: ");
        assertThat(new LoginPage(getWebDriver())
                .getPopOutConfirmation())
                .as("verify is login process failed")
                .isTrue();
        return this;
    }

    public LoginPageAssertion assertIfLogInSuccessful() {
        log.info("assertion started: ");
        assertThat(new LoginPage(getWebDriver())
                .getSeeProfileOption())
                .as("verify is login process successful")
                .isTrue();
        return this;
    }
}
