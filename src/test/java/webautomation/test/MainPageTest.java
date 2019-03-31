package webautomation.test;

import webautomation.assertion.MainPageAssertion;
import webautomation.listener.GeneralListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import webautomation.page.MainPage;

import java.io.IOException;

public class MainPageTest extends AbstractTest {

    @BeforeClass
    public void setUpBeforeClass() throws IOException {
        set();
    }

    @Test
    public void testIsEzegarkiPage() {
        new MainPage(driver)
                .assertIfProperPage(new MainPageAssertion(driver));
    }
}
