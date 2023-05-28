package test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page_object.*;

public class TestTransitions {
    private WebDriver driver;
    private final String email = SetTestClass.email;
    private final String pass = SetTestClass.password;
    private String token;

    @Before
    public void setup() {
        driver = SetWebDriver.setupDriver();
        token = SetTestClass.createUser();
    }

    @Test
    @DisplayName("Transitions to personal account from home page")
    @Description("This is test checks ability to transitions to personal account from home page")
    public void shouldBeTransitionsToPersonalAccountFromHomePage() {
        loginUser(email, pass, driver);
        PageObjectPersonalAccountPage objectPersonalAccountPage = new PageObjectPersonalAccountPage(driver);
        objectPersonalAccountPage.assertVisibleButtonExit();

    }

    @Test
    @DisplayName("Transitions to builder on home page from personal account page")
    @Description("This is test checks ability to transitions to builder on home page from personal account page")
    public void shouldBeTransitionsToBuilderOnHomePageFromPersonalAccount() {
        loginUser(email, pass, driver);
        PageObjectPersonalAccountPage objectPersonalAccountPage = new PageObjectPersonalAccountPage(driver);
        objectPersonalAccountPage.waitForLoadButtonBuilder();
        objectPersonalAccountPage.clickButtonBuilder();
        PageObjectHomePage objHomePage1 = new PageObjectHomePage(driver);
        objHomePage1.assertVisibleButtonPersonalAccount();
    }

    @Test
    @DisplayName("Transitions to home page from logo of personal account page")
    @Description("This is test checks ability to transitions to home page from logo of personal account page")
    public void shouldBeTransitionsToLogoFromPersonalAccount() {
        loginUser(email, pass, driver);
        PageObjectPersonalAccountPage objectPersonalAccountPage = new PageObjectPersonalAccountPage(driver);
        objectPersonalAccountPage.waitForLoadButtonBuilder();
        objectPersonalAccountPage.clickLogoBurger();
        PageObjectHomePage objHomePage1 = new PageObjectHomePage(driver);
        objHomePage1.assertVisibleButtonPersonalAccount();

    }

    @Test
    @DisplayName("Check exit from account")
    @Description("This is test checks ability to check exit from account from personal account page")
    public void shouldBeExitFromAccount() {
        loginUser(email, pass, driver);
        PageObjectPersonalAccountPage objectPersonalAccountPage = new PageObjectPersonalAccountPage(driver);
        objectPersonalAccountPage.assertVisibleButtonExit();
        objectPersonalAccountPage.clickExit();
        PageObjectLoginPage objLogPage1 = new PageObjectLoginPage(driver);
        objLogPage1.waitForLoadButtonLogin();

    }

    @After
    public void teardown() {
        driver.quit();
        String token = SetTestClass.loginUser();
        SetTestClass.deleteUser(token);

    }

    @Step("step login user")
    public void loginUser(String email, String pass, WebDriver driver) {
        driver.get(SetWebDriver.getUrlLogin());
        PageObjectLoginPage objLogPage = new PageObjectLoginPage(driver);
        objLogPage.waitForLoadButtonLogin();
        objLogPage.login(email, pass);
        PageObjectHomePage objHomePage = new PageObjectHomePage(driver);
        objHomePage.waitForLoadButtonPersonalAccount();
        objHomePage.clickPersonalAccount();
    }
}
