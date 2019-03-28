package test.order;

import assertion.CheckOutPageAssertion;
import listener.GeneralListener;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.MainPage;
import page.item.SearchPage;
import test.AbstractTest;

import java.io.IOException;

import static enums.SearchCriteria.BY_WATCH_BRAND;

@Listeners(GeneralListener.class)
public class CheckoutPageTest extends AbstractTest {

    private SearchPage searchPage;
    private CheckOutPageAssertion checkOutPageAssertion;
    private static final String EXPECTED_BUTTON_NAME = "Zamawiam i płacę";

    @BeforeTest
    public void setUpBeforeTest() throws IOException {
        set();
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
