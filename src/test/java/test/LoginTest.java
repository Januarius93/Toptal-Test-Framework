package test;

import assertion.LoginPageAssertion;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.MainPage;

import java.io.IOException;

public class LoginTest extends AbstractTest {

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
