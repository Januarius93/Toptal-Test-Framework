package webautomation.page.item;

import webautomation.assertion.item.SearchPageAssertion;
import webautomation.enums.SearchCriteria;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import webautomation.page.LoginPage;

import java.util.List;

public class SearchPage extends ShoppingBasketPage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);
    private static final String ADD_TO_SHOPPING_LIST_CLASS = "icon-shopping-cart-add";
    private static final String PRODUCT_BOX_CLASS = "product-box";

    @FindBy(tagName = "h1")
    private
    WebElement watchNameHeader;

    @FindBy(className = "cart")
    private
    WebElement addToShoppingListButton;

    @FindBy(xpath = "//h1[contains(text(),'Wyniki wyszukiwania')]")
    WebElement searchResultHeader;
    @FindBy(className = "icon-shopping-cart-add")
    WebElement addToShoppingListButton2;

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getWatchName() {
        log.info("get watch");
        return watchNameHeader.getText();
    }

    public SearchPage clickFirstProduct() {
        log.info("choosing first product");
        waitForExpectedCondition(ExpectedConditions.visibilityOf(searchResultHeader));
        freezeExecution(5);
        webDriver.findElements(By.className(PRODUCT_BOX_CLASS)).get(0).click();
        return this;
    }

    public SearchPage addToShoppingList(WebElement product) {
        log.info("adding to shopping list: " + product);
        freezeExecution(3);
        action.moveToElement(product).build().perform();
        freezeExecution(3);
        product.findElement(By.className(ADD_TO_SHOPPING_LIST_CLASS)).click();
        return this;
    }

    public SearchPage addToShoppingList() {
        log.info("adding to shopping list: ");
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(addToShoppingListButton));
        clickInElement(addToShoppingListButton);
        return this;
    }

    public List<WebElement> getProductAfterSearch() {
        log.info("getting products: ");
        return getElementsByClassName(PRODUCT_BOX_CLASS);
    }

    public SearchPage assertIsProperProductVisible(SearchPageAssertion searchPageAssertion, SearchCriteria searchCriteria) {
        searchPageAssertion.assertIsProperProductVisible(searchCriteria.getCriteria());
        return this;
    }
}
