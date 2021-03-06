package webautomation.test.item;

import webautomation.assertion.item.ShoppingBasketAssertion;
import webautomation.listener.GeneralListener;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import webautomation.page.MainPage;
import webautomation.page.item.SearchPage;
import webautomation.page.item.ShoppingBasketPage;
import webautomation.test.AbstractTest;

import java.io.IOException;
import java.util.List;

import static webautomation.enums.SearchCriteria.BY_WATCH_BRAND;

@Listeners(GeneralListener.class)
public class ShoppingBasketPageTest extends AbstractTest {

    private SearchPage searchPage;
    private ShoppingBasketPage shoppingBasketPage;
    private List<WebElement> productList;
    private ShoppingBasketAssertion shoppingBasketAssertion;

    @BeforeClass
    public void setUpBeforeClass() {
    }

    @BeforeTest
    public void setUpBeforeTest() throws IOException {
        set();
        searchPage = new SearchPage(driver);
        shoppingBasketAssertion = new ShoppingBasketAssertion(driver);
        shoppingBasketPage = new ShoppingBasketPage(driver);
        new MainPage(driver)
                .clickUserButton()
                .clickLoginOption()
                .login(login, password)
                .typeSearchCriteria(BY_WATCH_BRAND)
                .hitSearch();
        productList = searchPage.getProductAfterSearch();
    }

    @Test
    public void addProductsToShoppingList() {
        searchPage.addToShoppingList(productList.get(0))
                .assertIsProductAdded(shoppingBasketAssertion)
                .continueShopping()
                .addToShoppingList(productList.get(1))
                .assertIsProductAdded(shoppingBasketAssertion)
                .continueShopping();
    }

    @Test(dependsOnMethods = "addProductsToShoppingList")
    public void removeProductFromShoppingList() {
        shoppingBasketPage
                .goToShoppingList()
                .assertIsShoppinBasketVisible(shoppingBasketAssertion)
                .removeFromShoppingList(shoppingBasketAssertion);
    }


}
