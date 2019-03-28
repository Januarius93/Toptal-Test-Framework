package test;

import assertion.MainPageAssertion;
import listener.GeneralListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.MainPage;

import java.io.IOException;

@Listeners(GeneralListener.class)
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
