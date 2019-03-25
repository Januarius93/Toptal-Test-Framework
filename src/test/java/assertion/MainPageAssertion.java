package assertion;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import page.AbstractPage;
import page.LoginPage;
import page.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class MainPageAssertion extends AbstractPage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public MainPageAssertion(WebDriver webDriver) {
        super(webDriver);
    }

   public MainPageAssertion assertIfProperPage(String expectedURL) {
        log.info("assertion started");
        assertThat(new MainPage(getWebDriver()).getUrl()).as("verify is ezegarki page").isEqualTo(expectedURL);
        return this;
    }
}
