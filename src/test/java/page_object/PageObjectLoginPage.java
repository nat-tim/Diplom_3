package page_object;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectLoginPage {
    private By email = By.xpath(".//label[text()='Email']/following-sibling::input");
    private By password = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    private By buttonLogin = By.xpath("//button[text()='Войти']");
    private WebDriver driver;

    public PageObjectLoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void setEmail(String text) {
        driver.findElement(this.email).sendKeys(text);
    }

    public void setPassword(String text) {
        driver.findElement(this.password).sendKeys(text);
    }

    public void clickButtonLogin() {
        driver.findElement(buttonLogin).click();
    }

    @Step("login user")
    public void login(String email, String pass) {
        setEmail(email);
        setPassword(pass);
        clickButtonLogin();
    }

    public void waitForLoadButtonLogin() {
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(buttonLogin));

    }

}
