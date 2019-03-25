package page;

import assertion.SearchPageAssertion;
import enums.SearchCriteria;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage extends AbstractPage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);
    private static final String ADD_TO_SHOPPING_LIST_CLASS = "icon-shopping-cart-add";
    private static final String PRODUCT_BOX_CLASS = "product-box";

    @FindBy(tagName = "h1")
    WebElement watchNameHeader;

    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getWatchName() {
        log.info("get watch");
        return watchNameHeader.getText();
    }

    public SearchPage clickFirstProduct() {
        log.info("choosing first product");
        webDriver.findElements(By.className(PRODUCT_BOX_CLASS)).get(0).click();
        return this;
    }

    public SearchPage addToShoppingList(WebElement product) {
        action.moveToElement(product).build().perform();
        waitInTime(5, TimeUnit.SECONDS);
        product.findElement(By.className(ADD_TO_SHOPPING_LIST_CLASS)).click();
        return this;
    }

    public List<WebElement> getProductAfterSearch() {
        return getElementsByClassName(PRODUCT_BOX_CLASS);
    }

    public SearchPage assertIsProperProductVisible(SearchPageAssertion searchPageAssertion, SearchCriteria searchCriteria) {
        searchPageAssertion.assertIsProperProductVisible(searchCriteria.getCriteria());
        return this;
    }
}
