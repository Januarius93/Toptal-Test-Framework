package test;

import assertion.ShoppingBasketAssertion;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.MainPage;
import page.SearchPage;
import page.ShoppingBasketPage;

import java.io.IOException;
import java.util.List;

import static enums.SearchCriteria.BY_WATCH_BRAND;

public class ShoppingBasketTest extends AbstractTest {

    MainPage mainPage;
    SearchPage searchPage;
    ShoppingBasketPage shoppingBasketPage;
    List<WebElement> productList;
    ShoppingBasketAssertion shoppingBasketAssertion;

    @BeforeClass
    public void setUpBeforeClass() {
    }

    @BeforeTest
    public void setUpBeforeTest() throws IOException {
        set();
        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
        shoppingBasketAssertion = new ShoppingBasketAssertion(driver);
        shoppingBasketPage = new ShoppingBasketPage(driver);
        mainPage.clickUserButton()
                .clickLoginOption()
                .login(login, password)
                .typeSearchCriteria(BY_WATCH_BRAND)
                .hitSearch();
        productList = searchPage.getProductAfterSearch();
    }

    @Test
    public void addProductsToShoppingList() {
        searchPage.addToShoppingList(productList.get(0));
        shoppingBasketPage
                .assertIsProductAdded(shoppingBasketAssertion)
                .continueShopping();
        searchPage.addToShoppingList(productList.get(1));
        shoppingBasketPage
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
