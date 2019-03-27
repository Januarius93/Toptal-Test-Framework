package page;

import enums.UserFormData;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class UserFormPage extends CheckOutPage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    @FindBy(xpath = "//h1[contains(text(),'Dane osobowe')]")
    WebElement name;

    @FindBy(className = "main-submit-container")
    WebElement goToSummaryButton;


    public UserFormPage typeUserFormData() {
        waitForExpectedCondition(ExpectedConditions.visibilityOf(name));
        log.info(": typing into user form...");
        List<WebElement> inputsList = webDriver.findElements(By.xpath("//input"))
                .stream()
                .filter(e -> e.getAttribute("id").startsWith("o_"))
                .limit(9)
                .collect(Collectors.toList());
        inputsList.remove(7);
        List<UserFormData> userFormData = Arrays.asList(UserFormData.values());

        for (int i = 0; i < inputsList.size(); i++) {
            clearInput(inputsList.get(i));
            typeIntoInput(inputsList.get(i), userFormData.get(i).getData());
        }
        return this;
    }

    public UserFormPage goToSummary() {
        log.info("");
        scrollToElement(goToSummaryButton);
        waitForExpectedCondition(ExpectedConditions.elementToBeClickable(goToSummaryButton));
        clickInElement(goToSummaryButton);
        return this;
    }


    public UserFormPage(WebDriver webDriver) {
        super(webDriver);
    }
}
