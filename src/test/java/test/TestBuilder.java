package test;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.PageObjectHomePage;

public class TestBuilder {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = SetWebDriver.setupDriver();
        driver.get(SetWebDriver.getUrlHome());
    }

    @Test
    @DisplayName("Transitions to the section bun")
    @Description("This is test checks ability to Transitions to the section bun in builder")
    public void shouldBeTransitionsToBun() {

        PageObjectHomePage objHomePage = new PageObjectHomePage(driver);
        objHomePage.waitForLoadButtonPersonalAccount();
        objHomePage.assertTransitionsToSauce();
        objHomePage.assertTransitionsToBun();

    }


    @Test
    @DisplayName("Transitions to the section sause")
    @Description("This is test checks ability to Transitions to the section sause in builder")
    public void shouldBeTransitionsToSauce() {
        PageObjectHomePage objHomePage = new PageObjectHomePage(driver);
        objHomePage.waitForLoadButtonPersonalAccount();
        objHomePage.assertTransitionsToSauce();
    }

    @Test
    @DisplayName("Transitions to the section filling")
    @Description("This is test checks ability to Transitions to the section filling in builder")
    public void shouldBeTransitionsToFilling() {
        PageObjectHomePage objHomePage = new PageObjectHomePage(driver);
        objHomePage.waitForLoadButtonPersonalAccount();
        objHomePage.assertTransitionsToFilling();

    }

    @After
    public void teardown() {
        driver.quit();

    }

}
