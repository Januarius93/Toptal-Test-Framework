package test;

import assertion.CheckOutPageAssertion;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.MainPage;
import page.SearchPage;

import java.io.IOException;
import java.util.List;

import static enums.SearchCriteria.BY_WATCH_BRAND;

public class CheckoutTest extends AbstractTest {

    private SearchPage searchPage;
    private List<WebElement> productList;
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
