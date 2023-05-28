package test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page_object.*;

public class TestEntrance {
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
    @DisplayName("Login user with correct params")
    @Description("This is test checks ability to login user with correct params on registration page")
    public void shouldBeLoginUserWithCorrectParamsOnRegistrationPage() {
        driver.get(SetWebDriver.getUrlRegistration());
        PageObjectRegistrationPage objRegPage = new PageObjectRegistrationPage(driver);
        objRegPage.clickButtonLogin();
        loginUser(email, pass, driver);

    }

    @Test
    @DisplayName("Login user with correct params")
    @Description("This is test checks ability to login user with correct params on page of recover password")
    public void shouldBeLoginUserWithCorrectParamsOnRecoverPassPage() {
        driver.get(SetWebDriver.getUrlRecoverPass());
        PageObjectRecoverPassPage objRecoverPassPage = new PageObjectRecoverPassPage(driver);
        objRecoverPassPage.clickButtonLogin();
        loginUser(email, pass, driver);

    }

    @Test
    @DisplayName("Login user with correct params")
    @Description("This is test checks ability to login user with correct params on home page on button personal account")
    public void shouldBeLoginUserWithCorrectParamsOnHomePagePersonalAccount() {
        driver.get(SetWebDriver.getUrlHome());
        PageObjectHomePage objHomePage = new PageObjectHomePage(driver);
        objHomePage.clickPersonalAccount();
        loginUser(email, pass, driver);

    }

    @Test
    @DisplayName("Login user with correct params")
    @Description("This is test checks ability to login user with correct params on home page on button entrance")
    public void shouldBeLoginUserWithCorrectParamsOnHomePageButtonEntrance() {
        driver.get(SetWebDriver.getUrlHome());
        PageObjectHomePage objHomePage = new PageObjectHomePage(driver);
        objHomePage.clickButtonEntrance();
        loginUser(email, pass, driver);

    }

    @After
    public void teardown() {
        driver.quit();
        String token = SetTestClass.loginUser();
        SetTestClass.deleteUser(token);

    }

    @Step("step login user")
    public void loginUser(String email, String pass, WebDriver driver) {
        PageObjectLoginPage objLogPage = new PageObjectLoginPage(driver);
        objLogPage.waitForLoadButtonLogin();
        objLogPage.login(email, pass);
        PageObjectHomePage objHomePage = new PageObjectHomePage(driver);
        objHomePage.waitForLoadButtonPersonalAccount();
        objHomePage.clickPersonalAccount();
        PageObjectPersonalAccountPage objectPersonalAccountPage = new PageObjectPersonalAccountPage(driver);
        objectPersonalAccountPage.assertVisibleButtonExit();
    }
}
