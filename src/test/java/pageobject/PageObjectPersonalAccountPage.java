package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectPersonalAccountPage {
    private By buttonBuilder = By.xpath(".//p[text()='Конструктор']");
    private By logoBurger = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']/a");
    private By buttonExit = By.xpath(".//button[text()='Выход']");

    private WebDriver driver;

    public PageObjectPersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void assertVisibleButtonExit() {
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(buttonExit));
        driver.findElement(buttonExit).isDisplayed();
    }

    public void waitForLoadButtonBuilder() {
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(buttonBuilder));

    }

    public void clickButtonBuilder() {
        driver.findElement(buttonBuilder).click();
    }

    public void clickLogoBurger() {
        driver.findElement(logoBurger).click();
    }

    public void clickExit() {
        driver.findElement(buttonExit).click();
    }
}
