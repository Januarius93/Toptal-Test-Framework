package test;

import assertion.SearchPageAssertion;
import org.testng.annotations.*;
import page.MainPage;
import page.SearchPage;

import java.io.IOException;

import static enums.SearchCriteria.*;

public class SearchPageTest extends AbstractTest {
    private MainPage mainPage;
    private SearchPage searchPage;
    private SearchPageAssertion searchPageAssertion;

    @BeforeClass
    public void setUpBeforeClass() {
        searchPageAssertion = new SearchPageAssertion(driver);
        searchPage = new SearchPage(driver);
    }

    @BeforeTest
    public void setUpBeforeTest() throws IOException {
        set();
        mainPage = new MainPage(driver);
        mainPage.clickUserButton()
                .clickLoginOption()
                .login(login, password);
    }

    @Test
    public void searchByWatchBrandTest() {
        mainPage
                .typeSearchCriteria(BY_WATCH_BRAND)
                .hitSearch();
        searchPage
                .clickFirstProduct()
                .assertIsProperProductVisible(searchPageAssertion, BY_WATCH_BRAND);
    }

    @Test
    public void searchByWatchModelTest() {
        mainPage
                .typeSearchCriteria(BY_WATCH_MODEL)
                .hitSearch();
        searchPage
                .clickFirstProduct()
                .assertIsProperProductVisible(searchPageAssertion, BY_WATCH_MODEL);

    }

    @Test
    public void searchByGenderType() {
        mainPage
                .typeSearchCriteria(BY_GENDER_TYPE)
                .hitSearch();
        searchPage
                .clickFirstProduct()
                .assertIsProperProductVisible(searchPageAssertion, BY_GENDER_TYPE);
    }

    @AfterMethod
    public void tearDownAfterMethod() {
        mainPage.goToMainPage();
    }

}
