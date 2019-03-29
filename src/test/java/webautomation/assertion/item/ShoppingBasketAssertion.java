package webautomation.assertion.item;

import webautomation.assertion.AbstractAssertion;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import webautomation.page.LoginPage;
import webautomation.page.item.ShoppingBasketPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ShoppingBasketAssertion extends AbstractAssertion {
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public ShoppingBasketAssertion(WebDriver webDriver) {
        super(webDriver);
    }

    public ShoppingBasketAssertion assertIsProductAdded() {
        log.info("webautomation.assertion started: ");
        assertThat(new ShoppingBasketPage(getWebDriver()).isProductAdded())
                .as("verify is product added to shopping visible")
                .isTrue();
        return this;
    }

    public ShoppingBasketAssertion assertIsShoppinBasketVisible() {
        log.info("webautomation.assertion started: ");
        assertThat(new ShoppingBasketPage(getWebDriver()).isShoppingBasketVisible())
                .as("verify is shopping basket visible")
                .isTrue();
        return this;
    }

    public ShoppingBasketAssertion assertIsProductRemoved(int size) {
        log.info("webautomation.assertion started: ");
        assertThat(new ShoppingBasketPage(getWebDriver()).getElementsToRemove().size())
                .as("verify is shopping basket visible")
                .isEqualTo(size);
        return this;
    }
}
