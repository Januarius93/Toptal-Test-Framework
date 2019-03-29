package webautomation.assertion;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import webautomation.page.LoginPage;
import webautomation.page.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageAssertion extends AbstractAssertion {
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public MainPageAssertion(WebDriver webDriver) {
        super(webDriver);
    }

    public MainPageAssertion assertIfProperPage(String expectedURL) {
        log.info("webautomation.assertion started");
        assertThat(new MainPage(getWebDriver()).getUrl()).as("verify is ezegarki webautomation.page").isEqualTo(expectedURL);
        return this;
    }
}
