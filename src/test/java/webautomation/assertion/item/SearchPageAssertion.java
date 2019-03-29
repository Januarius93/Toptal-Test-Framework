package webautomation.assertion.item;

import webautomation.assertion.AbstractAssertion;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import webautomation.page.LoginPage;
import webautomation.page.item.SearchPage;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchPageAssertion extends AbstractAssertion {
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public SearchPageAssertion(WebDriver webDriver) {
        super(webDriver);
    }

    public SearchPageAssertion assertIsProperProductVisible(String expectedProductName) {
        log.info("webautomation.assertion started: ");
        assertThat(new SearchPage(getWebDriver()).getWatchName())
                .as("verify if " + expectedProductName + " is found"
                ).contains(expectedProductName);
        return this;
    }
}
