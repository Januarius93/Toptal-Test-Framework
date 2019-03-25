package page;

import assertion.ShoppingBasketAssertion;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShoppingBasketPage extends AbstractPage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);
    private static final String REMOVE_FROM_SHOPPING_BASKET_XPATH = "//button[contains(@class,'cart-delete')]";
    @FindBy(className = "cart-add-product-container")
    WebElement productAdded;

    @FindBy(className = "close-modal")
    WebElement continueShoppingButton;

    @FindBy(className = "icon-shopping-cart")
    WebElement shoppingList;

    @FindBy(tagName = "h1")
    WebElement shoppingBasketHeader;


    public ShoppingBasketPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ShoppingBasketPage goToShoppingList() {
        log.info(": going to shopping list");
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(shoppingList));
        clickInElement(shoppingList);
        return this;
    }

    public boolean isProductAdded() {
        log.info(": is product added");
        waitForExpectedCondition(ExpectedConditions.visibilityOf(productAdded));
        return productAdded.isDisplayed();
    }

    public boolean isShoppingBasketVisible() {
        log.info(": is visible");
        waitForExpectedCondition(ExpectedConditions.visibilityOf(shoppingBasketHeader));
        return shoppingBasketHeader.isDisplayed();
    }

    public void continueShopping() {
        log.info(": getting back to shopping");
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
    }

    public List<WebElement> getElementsToRemove() {
        waitInTime(2, TimeUnit.SECONDS);
        return webDriver.findElements(By.xpath(REMOVE_FROM_SHOPPING_BASKET_XPATH));
    }

    public ShoppingBasketPage removeFromShoppingList(ShoppingBasketAssertion shoppingBasketAssertion) {
        waitForExpectedCondition(ExpectedConditions.visibilityOf(shoppingBasketHeader));
        List<WebElement> removeButtonList = getElementsToRemove();
        removeButtonList.get(0).click();
        waitForExpectedCondition(ExpectedConditions.visibilityOf(webDriver.findElement(By.xpath("//button[contains(@class,'btn-loader')]"))));
        waitForExpectedCondition(ExpectedConditions.invisibilityOf(webDriver.findElement(By.xpath("//button[contains(@class,'btn-loader')]"))));
        assertIsProductRemoved(shoppingBasketAssertion, removeButtonList.size() - 1);


        return this;
    }

    public ShoppingBasketPage assertIsProductAdded(ShoppingBasketAssertion shoppingBasketAssertion) {
        shoppingBasketAssertion.assertIsProductAdded();
        return this;
    }

    public ShoppingBasketPage assertIsShoppinBasketVisible(ShoppingBasketAssertion shoppingBasketAssertion) {
        shoppingBasketAssertion.assertIsShoppinBasketVisible();
        return this;
    }

    public ShoppingBasketPage assertIsProductRemoved(ShoppingBasketAssertion shoppingBasketAssertion, int size) {
        shoppingBasketAssertion.assertIsProductRemoved(size);
        return this;
    }


}
