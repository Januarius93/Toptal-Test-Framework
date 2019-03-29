package webautomation.assertion;

import org.openqa.selenium.WebDriver;
import webautomation.page.AbstractPage;

public abstract class AbstractAssertion extends AbstractPage {
    public AbstractAssertion(WebDriver webDriver) {
        super(webDriver);
    }
}
