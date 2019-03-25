package test;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.MainPage;
import page.SearchPage;

import java.io.IOException;
import java.util.List;

import static enums.SearchCriteria.BY_WATCH_BRAND;

public class OrderSummaryTest extends AbstractTest {

    private SearchPage searchPage;
    private List<WebElement> productList;

    @BeforeTest
    public void setUpBeforeTest() throws IOException {
        set();
        searchPage = new SearchPage(driver);
        new MainPage(driver)
                .clickUserButton()
                .clickLoginOption()
                .login(login, password)
                .typeSearchCriteria(BY_WATCH_BRAND)
                .hitSearch();
        productList = searchPage.getProductAfterSearch();
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
                .continueOrder();
    }
}
