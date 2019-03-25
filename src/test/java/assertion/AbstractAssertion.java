package assertion;

import org.openqa.selenium.WebDriver;
import page.AbstractPage;

public abstract class AbstractAssertion extends AbstractPage {
    public AbstractAssertion(WebDriver webDriver) {
        super(webDriver);
    }
}
