package webautomation.test.item;

import webautomation.assertion.item.SearchPageAssertion;
import webautomation.listener.GeneralListener;
import org.testng.annotations.*;
import webautomation.page.MainPage;
import webautomation.test.AbstractTest;

import java.io.IOException;

import static webautomation.enums.SearchCriteria.*;

@Listeners(GeneralListener.class)
public class SearchPageTest extends AbstractTest {
    private MainPage mainPage;
    private SearchPageAssertion searchPageAssertion;

    @BeforeClass
    public void setUpBeforeClass() {
        searchPageAssertion = new SearchPageAssertion(driver);
    }

    @BeforeTest
    public void setUpBeforeTest() throws IOException {
        set();
        mainPage = new MainPage(driver)
                .clickUserButton()
                .clickLoginOption()
                .login(login, password);
    }

    @Test
    public void searchByWatchBrandTest() {
        mainPage
                .typeSearchCriteria(BY_WATCH_BRAND)
                .hitSearch()
                .clickFirstProduct()
                .assertIsProperProductVisible(searchPageAssertion, BY_WATCH_BRAND);
    }

    @Test
    public void searchByWatchModelTest() {
        mainPage
                .typeSearchCriteria(BY_WATCH_MODEL)
                .hitSearch()
                .clickFirstProduct()
                .assertIsProperProductVisible(searchPageAssertion, BY_WATCH_MODEL);
    }

    @Test
    public void searchByGenderType() {
        mainPage
                .typeSearchCriteria(BY_GENDER_TYPE)
                .hitSearch()
                .clickFirstProduct()
                .assertIsProperProductVisible(searchPageAssertion, BY_GENDER_TYPE);
    }

    @AfterMethod
    public void tearDownAfterMethod() {
        mainPage.goToMainPage();
    }

}
