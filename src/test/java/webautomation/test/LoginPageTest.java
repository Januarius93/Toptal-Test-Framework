package webautomation.test;

import webautomation.assertion.LoginPageAssertion;
import webautomation.listener.GeneralListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import webautomation.page.MainPage;

import java.io.IOException;

@Listeners(GeneralListener.class)
public class LoginPageTest extends AbstractTest {

    private static final String WRONG_PASSWORD = "paswd3d";
    private MainPage mainPage;
    private LoginPageAssertion loginPageAssertion;


    @BeforeClass
    public void setUpBeforeClass() throws IOException {
        set();
        mainPage = new MainPage(driver);
        loginPageAssertion = new LoginPageAssertion(driver);
    }

    @Test
    public void emptyFieldLoginTest() {
        mainPage.clickUserButton()
                .clickLoginOption()
                .emptyLogin()
                .assertIfLoginProcessFailed(loginPageAssertion)
                .closeLoginPopOut();
    }

    @Test(dependsOnMethods = "emptyFieldLoginTest")
    public void loginWithoutPasswordTest() {
        mainPage.clickUserButton()
                .clickLoginOption()
                .login(login, WRONG_PASSWORD, true)
                .assertIfLoginProcessFailed(loginPageAssertion)
                .closeLoginPopOut();
    }


    @Test(dependsOnMethods = "loginWithoutPasswordTest")
    public void correctLoginTest() {
        mainPage.clickUserButton()
                .clickLoginOption()
                .login(login, password, true)
                .clickToSeeProfileOption()
                .assertIfLogInSuccessful(loginPageAssertion);
    }
}
