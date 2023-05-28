package test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page_object.PageObjectRegistrationPage;

public class TestRegistrationNegativ {
    private WebDriver driver;
    private final String name = SetTestClass.name;
    private final String email = SetTestClass.email;

    @Before
    public void setup() {
        driver = SetWebDriver.setupDriver();
        driver.get(SetWebDriver.getUrlRegistration());
    }

    @Test(expected = AssertionError.class)
    @DisplayName("Login user with incorrect params")
    @Description("This is test checks inability to login user with incorrect params(short pass) on registration page")
    public void shouldBeRegistrationUserWithIncorrectParams() throws AssertionError {
        PageObjectRegistrationPage objRegPage = new PageObjectRegistrationPage(driver);
        objRegPage.register(name, email, "123");
        objRegPage.assertTextError();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

