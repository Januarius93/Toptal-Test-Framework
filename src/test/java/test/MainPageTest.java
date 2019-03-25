package test;

import assertion.MainPageAssertion;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.MainPage;

import java.io.IOException;

public class MainPageTest extends AbstractTest {
    MainPage mainPage;
    MainPageAssertion mainPageAssertion;

    @BeforeClass
    public void setUpBeforeClass() throws IOException {
        set();
        mainPage = new MainPage(driver);
        mainPageAssertion = new MainPageAssertion(driver);
    }

    @Test
    public void testIsEzegarkiPage() {
        mainPage.assertIfProperPage(mainPageAssertion);
    }
}
