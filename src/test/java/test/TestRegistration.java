package test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page_object.PageObjectHomePage;
import page_object.PageObjectLoginPage;
import page_object.PageObjectPersonalAccountPage;
import page_object.PageObjectRegistrationPage;

public class TestRegistration {
    private WebDriver driver;

    private final String name = SetTestClass.name;
    private final String email = SetTestClass.email;
    private final String pass = SetTestClass.password;

    @Before
    public void setup() {
        driver = SetWebDriver.setupDriver();
        driver.get(SetWebDriver.getUrlRegistration());
    }

    @Test
    @DisplayName("Registration user with correct params")
    @Description("This is test checks ability to registration user with correct params on registration page")
    public void shouldBeRegistrationUserWithCorrectParams() {

        PageObjectRegistrationPage objRegPage = new PageObjectRegistrationPage(driver);
        objRegPage.register(name, email, pass);
        PageObjectLoginPage objLogPage = new PageObjectLoginPage(driver);
        objLogPage.waitForLoadButtonLogin();
        objLogPage.login(email, pass);
        PageObjectHomePage objHomePage = new PageObjectHomePage(driver);
        objHomePage.waitForLoadButtonPersonalAccount();
        objHomePage.clickPersonalAccount();
        PageObjectPersonalAccountPage objectPersonalAccountPage = new PageObjectPersonalAccountPage(driver);
        objectPersonalAccountPage.assertVisibleButtonExit();

    }

    @After
    public void teardown() {
        driver.quit();
        String token = SetTestClass.loginUser();
        SetTestClass.deleteUser(token);

    }
}
