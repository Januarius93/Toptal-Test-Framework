package webautomation.test.order;

import webautomation.assertion.CheckOutPageAssertion;
import webautomation.listener.GeneralListener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import webautomation.page.MainPage;
import webautomation.page.item.SearchPage;
import webautomation.test.AbstractTest;

import java.io.IOException;

import static webautomation.enums.SearchCriteria.BY_WATCH_BRAND;

@Listeners(GeneralListener.class)
public class CheckoutPageTest extends AbstractTest {

    private SearchPage searchPage;
    private CheckOutPageAssertion checkOutPageAssertion;
    private static final String EXPECTED_BUTTON_NAME = "Zamawiam";

    @BeforeTest
    public void setUpBeforeTest() throws IOException {
        set();
        driver.manage().deleteAllCookies();
        searchPage = new SearchPage(driver);
        checkOutPageAssertion = new CheckOutPageAssertion(driver);
        new MainPage(driver)
                .clickUserButton()
                .clickLoginOption()
                .login(login, password)
                .typeSearchCriteria(BY_WATCH_BRAND)
                .hitSearch();
    }

    @Test
    public void testIfWatchCanBeBought() {
        searchPage
                .clickFirstProduct()
                .addToShoppingList()
                .goToCheckout()
                .chooseGlsDelivery()
                .continueOrder()
                .chooseBankTransfer()
                .goToUserForm()
                .typeUserFormData()
                .goToSummary()
                .assertThatWatchCanBeBought(checkOutPageAssertion, EXPECTED_BUTTON_NAME);

    }
}
