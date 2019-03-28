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

public class ShoppingBasketPage extends DeliveryMethodPage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);
    private static final String REMOVE_FROM_SHOPPING_BASKET_XPATH = "//button[contains(@class,'cart-delete')]";
    @FindBy(className = "cart-add-product-container")
    WebElement productAdded;

    @FindBy(className = "close-modal")
    WebElement continueShoppingButton;

    @FindBy(className = "icon-shopping-cart")
    WebElement shoppingList;

    @FindBy(xpath = "//h1[contains(text(),'Twój koszyk')]")
    WebElement shoppingBasketHeader;

    @FindBy(linkText = "Przejdź do kasy")
    WebElement goToCheckOutButton;

    @FindBy(className = "cart-delete")
    WebElement removeButton;


    public ShoppingBasketPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ShoppingBasketPage goToShoppingList() {
        log.info("going to shopping list: ");
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(shoppingList));
        clickInElement(shoppingList);
        return this;
    }

    public SearchPage goToCheckout() {
        log.info("going to checkout: ");
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(goToCheckOutButton));
        clickInElement(goToCheckOutButton);
        return new SearchPage(webDriver);
    }

    public boolean isProductAdded() {
        log.info("is product added: ");
        waitForExpectedCondition(ExpectedConditions.visibilityOf(productAdded));
        return productAdded.isDisplayed();
    }

    public boolean isShoppingBasketVisible() {
        log.info("is visible: ");
        waitForExpectedCondition(ExpectedConditions.visibilityOf(shoppingBasketHeader));
        return shoppingBasketHeader.isDisplayed();
    }

    public SearchPage continueShopping() {
        log.info("getting back to shopping: ");
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(continueShoppingButton));
        continueShoppingButton.click();
        return new SearchPage(webDriver);
    }

    public List<WebElement> getElementsToRemove() {
        log.info("obtaining products to remove: ");
        waitInTime(2, TimeUnit.SECONDS);
        return webDriver.findElements(By.xpath(REMOVE_FROM_SHOPPING_BASKET_XPATH));
    }

    public ShoppingBasketPage removeFromShoppingList(ShoppingBasketAssertion shoppingBasketAssertion) {
        log.info("removing from shopping list: ");
        waitForExpectedCondition(ExpectedConditions.visibilityOf(shoppingBasketHeader));
        List<WebElement> removeButtonList = getElementsToRemove();
        removeButtonList.get(0).click();
        waitForExpectedCondition(ExpectedConditions.attributeToBe(removeButton,"class", "btn btn-danger btn-sm cart-delete"));
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
